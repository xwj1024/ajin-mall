package cn.leemay.mall.common.db.anno;

import cn.leemay.mall.common.db.config.MybatisPlusConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Ajin
 * @since 2021-04-27
 * 此注解用于是否启用mybatis-plus自定义配置
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MybatisPlusConfig.class})
public @interface EnableMybatisPlus {
}
