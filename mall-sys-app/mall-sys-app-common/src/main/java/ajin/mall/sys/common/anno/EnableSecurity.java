package ajin.mall.sys.common.anno;

import ajin.mall.sys.common.aspect.AuthAspect;
import ajin.mall.sys.common.config.WebMvcConfig;
import ajin.mall.sys.common.interceptor.FeignInterceptor;
import ajin.mall.sys.common.interceptor.HeaderInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用安全
 *
 * @author Ajin
 * @date 2022/04/21
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({AuthAspect.class, FeignInterceptor.class, HeaderInterceptor.class, WebMvcConfig.class})
public @interface EnableSecurity {
}
