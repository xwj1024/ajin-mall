package ajin.mall.sys.common.anno;

import java.lang.annotation.*;

/**
 * 权限访问控制
 *
 * @author Ajin
 * @date 2022/04/18
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OnlyPerm {

}
