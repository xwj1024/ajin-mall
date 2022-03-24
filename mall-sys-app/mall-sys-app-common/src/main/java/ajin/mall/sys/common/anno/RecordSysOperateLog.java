package ajin.mall.sys.common.anno;

import ajin.mall.common.data.enums.TableInfo;

import java.lang.annotation.*;

/**
 * @author Ajin
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordSysOperateLog {

    /**
     * 操作描述
     */
    String description() default "";

    /**
     * 是否保存请求的参数
     */
    boolean saveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean saveResponseData() default true;

    /**
     * 是否保存原始数据
     */
    TableInfo saveSourceData() default TableInfo.NONE;

}
