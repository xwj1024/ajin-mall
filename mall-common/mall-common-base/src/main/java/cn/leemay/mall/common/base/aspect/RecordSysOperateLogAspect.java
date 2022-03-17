package cn.leemay.mall.common.base.aspect;

import cn.leemay.mall.common.base.anno.RecordSysOperateLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
    @Pointcut("@annotation(cn.leemay.mall.common.base.anno.RecordSysOperateLog)")
    public void sysOperateLogPointCut() {
    }


    /**
     * 处理完请求后执行
     *
     * @param joinPoint  切点
     * @param rsol    日志注解
     * @param jsonResult 返回值
     */
    @AfterReturning(pointcut = "@annotation(rsol)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, RecordSysOperateLog rsol, Object jsonResult) {
        handleLog(joinPoint, rsol, null, jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param rsol   日志注解
     * @param e         异常
     */
    @AfterThrowing(value = "@annotation(rsol)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, RecordSysOperateLog rsol, Exception e) {
        handleLog(joinPoint, rsol, e, null);
    }

    private void handleLog(final JoinPoint joinPoint, RecordSysOperateLog rsol, final Exception e, Object jsonResult) {
        // todo
    }

}
