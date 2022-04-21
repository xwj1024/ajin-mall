package ajin.mall.sys.common.config;

import ajin.mall.sys.common.interceptor.FeignInterceptor;
import ajin.mall.sys.common.interceptor.HeaderInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * web mvc配置
 *
 * @author Ajin
 * @date 2022/04/21
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private HeaderInterceptor headerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerInterceptor);
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignInterceptor();
    }
}
