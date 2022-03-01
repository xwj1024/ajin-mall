package cn.leemay.mall.common.base.config;

import cn.leemay.mall.common.base.interceptor.SameUriDataInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Ajin
 * @since 2021-05-18
 */
@Configuration
@EnableConfigurationProperties(SameUriDataInterceptor.class)
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private SameUriDataInterceptor sameUriDataInterceptor;

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sameUriDataInterceptor).addPathPatterns("/**");
    }
}
