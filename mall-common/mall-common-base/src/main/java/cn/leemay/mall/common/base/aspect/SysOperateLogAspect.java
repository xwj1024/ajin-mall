package cn.leemay.mall.common.base.aspect;

import cn.leemay.mall.common.base.anno.SysOperateLog;
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
public class SysOperateLogAspect {

    /**
     * 配置织入点
     */
    @Pointcut("@annotation(cn.leemay.mall.common.base.anno.SysOperateLog)")
    public void sysOperateLogPointCut() {
    }


    /**
     * 处理完请求后执行
     *
     * @param joinPoint  切点
     * @param solAnno    日志注解
     * @param jsonResult 返回值
     */
    @AfterReturning(pointcut = "@annotation(solAnno)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, SysOperateLog solAnno, Object jsonResult) {
        handleLog(joinPoint, solAnno, null, jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param solAnno   日志注解
     * @param e         异常
     */
    @AfterThrowing(value = "@annotation(solAnno)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, SysOperateLog solAnno, Exception e) {
        handleLog(joinPoint, solAnno, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, SysOperateLog solAnno, final Exception e, Object jsonResult) {
        // todo
    }

}
