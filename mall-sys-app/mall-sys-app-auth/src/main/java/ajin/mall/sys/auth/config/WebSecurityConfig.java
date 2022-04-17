package ajin.mall.sys.auth.config;

import ajin.mall.sys.auth.handler.CustomAuthenticationFailureHandler;
import ajin.mall.sys.auth.handler.CustomAuthenticationSuccessHandler;
import ajin.mall.sys.auth.handler.CustomLogoutSuccessHandler;
import ajin.mall.sys.auth.handler.CustomUserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author Ajin
 * @since 2021-06-20
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 登录成功处理逻辑
     */
    @Resource
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    /**
     * 登录失败处理逻辑
     */
    @Resource
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    /**
     * 登出成功处理逻辑
     */
    @Resource
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    /**
     * 权限拒绝处理逻辑
     */
//    @Resource
//    private CustomAccessDeniedHandler customAccessDeniedHandler;

    /**
     * 匿名用户访问无权限资源时的异常
     */
//    @Resource
//    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    /**
     * 访问决策管理器
     */
//    @Resource
//    private CustomAccessDecisionManager customAccessDecisionManager;

    /**
     * 实现权限拦截
     */
//    @Resource
//    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;

//    @Resource
//    private CustomAbstractSecurityInterceptor customAbstractSecurityInterceptor;
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 设置默认的加密方式
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        // 获取用户账号密码及权限信息
        return new CustomUserDetailServiceImpl();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests().anyRequest().authenticated()/*.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        // 决策管理器
//                        o.setAccessDecisionManager(customAccessDecisionManager);
                        // 安全元数据源
//                        o.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        return o;
                    }
                })
                // 登出，允许所有用户
                */.and().logout().permitAll()
                // 登出成功处理逻辑
                .logoutSuccessHandler(customLogoutSuccessHandler)
                // 登录，允许所有用户
                .and().formLogin().permitAll()
                // 登录成功处理逻辑
                .successHandler(customAuthenticationSuccessHandler)
                // 登录失败处理逻辑
                .failureHandler(customAuthenticationFailureHandler)
                // 异常处理(权限拒绝、登录失效等)
                .and().exceptionHandling()
                // 权限拒绝处理逻辑
//                .accessDeniedHandler(customAccessDeniedHandler)
                // 匿名用户访问无权限资源时的异常处理
//                .authenticationEntryPoint(customAuthenticationEntryPoint)
                // 会话管理
                .and().sessionManagement()
                // jwt不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(customAbstractSecurityInterceptor, FilterSecurityInterceptor.class);
    }
}
