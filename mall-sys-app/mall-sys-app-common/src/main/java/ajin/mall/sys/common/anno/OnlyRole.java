package ajin.mall.sys.common.anno;

import ajin.mall.sys.common.enums.Logical;

import java.lang.annotation.*;

/**
 * 角色访问控制
 *
 * @author Ajin
 * @date 2022/04/18
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OnlyRole {

    String[] value() default {};

    Logical logical() default Logical.OR;
}
