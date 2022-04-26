package ajin.mall.sys.common.anno;

import java.lang.annotation.*;

/**
 * 只有自我
 *
 * @author Ajin
 * @date 2022/04/22
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OnlySelf {

    String form();

    String claim();
}
