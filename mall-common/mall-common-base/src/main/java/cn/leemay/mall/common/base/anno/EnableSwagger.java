package cn.leemay.mall.common.base.anno;

import cn.leemay.mall.common.base.config.SwaggerConfig;
import cn.leemay.mall.common.base.property.SwaggerProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Ajin
 * @since 2021-04-15
 * swagger3只要引入依赖默认自动启用swagger
 * 此注解用于是否启用自定义swagger配置信息
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({SwaggerProperties.class,
        SwaggerConfig.class})
public @interface EnableSwagger {
}
