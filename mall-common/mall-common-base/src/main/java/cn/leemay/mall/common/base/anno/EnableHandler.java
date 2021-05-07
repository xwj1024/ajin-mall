package cn.leemay.mall.common.base.anno;

import cn.leemay.mall.common.base.handler.ExceptionHandlers;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 此注解用于是否启用自定义处理
 *
 * @author Ajin
 * @since 2021-04-27
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ExceptionHandlers.class})
public @interface EnableHandler {
}
