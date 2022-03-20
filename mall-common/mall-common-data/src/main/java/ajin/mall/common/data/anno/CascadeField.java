package ajin.mall.common.data.anno;


import ajin.mall.common.data.enums.TableInfo;

import java.lang.annotation.*;

/**
 * @author Ajin
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CascadeField {

    /**
     * 主表名，即为要删除数据的表名
     */
    TableInfo sourceTable();

    /**
     * 关联表名，即为当前使用该注解的类所对应的表名
     */
    TableInfo linkedTable();

    /**
     * 子表中关联字段，即为该字段所对应的表中字段名
     */
    String linkedField();

    /**
     * 能否直接删除关联表中数据
     */
    boolean enableDelete() default true;
}
