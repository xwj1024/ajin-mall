package ajin.mall.sys.common.anno;

import ajin.mall.sys.common.enums.Logical;

import java.lang.annotation.*;

/**
 * 只有角色
 *
 * @author Ajin
 * @date 2022/04/18
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OnlyRole {

    String[] value() default {};

    Logical logical() default Logical.AND;
}
