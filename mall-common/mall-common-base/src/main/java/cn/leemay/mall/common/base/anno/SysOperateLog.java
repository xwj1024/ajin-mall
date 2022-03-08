package cn.leemay.mall.common.base.anno;

import java.lang.annotation.*;

/**
 * @author A
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
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean isSaveResponseData() default true;

}
