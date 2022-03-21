package ajin.mall.common.base.aspect;

import ajin.mall.common.base.anno.RecordSysOperateLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Ajin
 */
@Component
@Aspect
public class RecordSysOperateLogAspect {

    /**
     * 配置织入点
     */
    @Pointcut("@annotation(ajin.mall.common.base.anno.RecordSysOperateLog)")
    public void sysOperateLogPointCut() {
    }


    /**
     * 处理请求前执行
     *
     * @param joinPoint 切点
     */
    @Before("sysOperateLogPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        handleLog(joinPoint);
    }

    private void handleLog(final JoinPoint joinPoint) {
        // todo
    }

}
