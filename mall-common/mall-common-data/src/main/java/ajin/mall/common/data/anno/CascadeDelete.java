package ajin.mall.common.data.anno;


import ajin.mall.common.data.enums.TableInfo;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * @author Ajin
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Transactional(rollbackFor = Throwable.class)
public @interface CascadeDelete {

    /**
     * 要删除的表名
     */
    TableInfo value();

}
