package cn.leemay.mall.common.base.anno;

import java.lang.annotation.*;

/**
 * 自定义注解防止表单重复提交
 *
 * @author ruoyi
 * @since 2021-05-17
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {
}
