package ajin.mall.sys.search.anno;

import java.lang.annotation.*;

/**
 * ES索引字段映射，用于代码创建索引
 *
 * @author Ajin
 * @since 2021-04-14
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EsField {

    /**
     * 字段类型
     */
    String type() default "";

    /**
     * 是否索引
     */
    boolean index() default true;

    /**
     * 分词类型
     */
    String analyzer() default "standard";
}