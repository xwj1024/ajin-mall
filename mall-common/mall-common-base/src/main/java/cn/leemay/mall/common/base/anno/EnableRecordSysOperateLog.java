package cn.leemay.mall.common.base.anno;

import cn.leemay.mall.common.base.aspect.RecordSysOperateLogAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Ajin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({RecordSysOperateLogAspect.class})
public @interface EnableRecordSysOperateLog {

}
