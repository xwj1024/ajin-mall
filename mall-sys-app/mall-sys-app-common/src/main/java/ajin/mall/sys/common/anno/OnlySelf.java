package ajin.mall.sys.common.anno;

import java.lang.annotation.*;

/**
 * 自己操作自己数据
 *
 * @author Ajin
 * @date 2022/04/22
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OnlySelf {

    String param();

    String claim();
}
