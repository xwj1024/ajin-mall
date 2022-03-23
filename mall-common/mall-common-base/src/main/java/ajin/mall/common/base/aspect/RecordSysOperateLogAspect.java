package ajin.mall.common.base.aspect;

import ajin.mall.common.base.anno.RecordSysOperateLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Ajin
 */
@Component
@Aspect
public class RecordSysOperateLogAspect {

    /**
     * 处理请求前执行
     *
     * @param joinPoint 切点
     */
    @Before("@annotation(ajin.mall.common.base.anno.RecordSysOperateLog)")
    public void doBefore(JoinPoint joinPoint) {
        handleLog(joinPoint);
    }

    private void handleLog(final JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method          method    = signature.getMethod();
        // 获取注解
        if (method.isAnnotationPresent(RecordSysOperateLog.class)) {
            RecordSysOperateLog sysOperateLogAnno = method.getAnnotation(RecordSysOperateLog.class);

        }
    }

}
