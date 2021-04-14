package cn.leemay.mall.search.anno;

import java.lang.annotation.*;

/**
 * ES索引字段映射，用于代码创建索引
 *
 * @author Ajin
 * @create 2021/4/14
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EsField {

    /**
     * 字段类型
     */
    String type() default "text";

    /**
     * 是否索引
     */
    boolean index() default true;

    /**
     * 分词类型
     */
    String analyzer() default "standard";
}