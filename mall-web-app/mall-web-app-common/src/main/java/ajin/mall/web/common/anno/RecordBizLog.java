package ajin.mall.web.common.anno;

import ajin.mall.common.data.enums.TableInfo;

import java.lang.annotation.*;


/**
 * 商务日志记录
 *
 * @author Ajin
 * @date 2022/04/15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordBizLog {

    /**
     * 操作描述
     */
    String value() default "";

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
