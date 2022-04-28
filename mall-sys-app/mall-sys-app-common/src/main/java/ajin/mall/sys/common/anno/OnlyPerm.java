package ajin.mall.sys.common.anno;

import java.lang.annotation.*;

/**
 * 只允许
 *
 * @author Ajin
 * @date 2022/04/18
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OnlyPerm {

}
