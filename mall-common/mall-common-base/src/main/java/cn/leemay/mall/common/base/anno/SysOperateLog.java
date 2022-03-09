package cn.leemay.mall.common.base.anno;

import java.lang.annotation.*;

/**
 * @author Ajin
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysOperateLog {

    /**
     * 操作描述
     */
    String desc() default "";

    /**
     * 是否保存请求的参数
     */
    boolean saveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean saveResponseData() default true;

}
