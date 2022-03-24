package ajin.mall.sys.common.aspect;

import ajin.mall.common.base.util.StringUtils;
import ajin.mall.common.data.entity.system.SysOperateLog;
import ajin.mall.common.data.mapper.CommonMapper;
import ajin.mall.sys.common.anno.RecordSysOperateLog;
import ajin.mall.sys.system.service.SysOperateLogService;
import com.alibaba.fastjson.JSON;
import org.apache.dubbo.config.annotation.Reference;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Ajin
 */
@Component
@Aspect
public class RecordSysOperateLogAspect {

    @Reference
    private SysOperateLogService sysOperateLogService;

    @Resource
    private CommonMapper commonMapper;

    /**
     * 处理环绕执行
     *
     * @param pjp 切点
     */
    @Around("@annotation(ajin.mall.sys.common.anno.RecordSysOperateLog)")
    public Object doAround(ProceedingJoinPoint pjp) {
        return handleLog(pjp);
    }


    private Object handleLog(final ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method          method    = signature.getMethod();
        Object          result    = null;

        if (method.isAnnotationPresent(RecordSysOperateLog.class)) {
            // 数据库系统操作日志
            SysOperateLog sysOperateLog = new SysOperateLog();
            // 获取注解
            RecordSysOperateLog sysOperateLogAnno = method.getAnnotation(RecordSysOperateLog.class);
            String              description       = sysOperateLogAnno.description();
            sysOperateLog.setDescription(description);

            // todo 处理用户id，请求地址，请求方法
            /*sysOperateLog.setSysUserId();
            sysOperateLog.setRemoteIp();
            sysOperateLog.setRequestUri();
            sysOperateLog.setRequestMethod();*/

            // 设置方法名称
            String className  = pjp.getTarget().getClass().getName();
            String methodName = pjp.getSignature().getName();
            sysOperateLog.setMethodName(className + "." + methodName + "()");
            // 获取请求参数
            Object[] args = pjp.getArgs();
            if (args != null && args.length > 0) {
                Object arg  = args[0];
                String json = JSON.toJSONString(arg);
                // 设置请求参数
                if (sysOperateLogAnno.saveRequestData()) {
                    sysOperateLog.setRequestParam(json);
                }
                Map    map       = JSON.parseObject(json, Map.class);
                Long   id        = (Long) map.get("id");
                String tableName = sysOperateLogAnno.saveSourceData().getName();
                if (!StringUtils.isEmpty(tableName)) {
                    Map    sourceMap  = commonMapper.selectById(tableName, id);
                    String sourceDate = JSON.toJSONString(sourceMap);
                    sysOperateLog.setSourceData(sourceDate);
                }
            }
            try {
                // 执行方法
                result = pjp.proceed();
                // 设置响应结果
                if (sysOperateLogAnno.saveResponseData()) {
                    sysOperateLog.setResponseResult(JSON.toJSONString(result));
                }
            } catch (Throwable e) {
                sysOperateLog.setExceptionInfo(e.getMessage());
            }
            sysOperateLog.setOperateTime(LocalDateTime.now());
            // 保存数据库
            sysOperateLogService.add(sysOperateLog);
        }
        return result;
    }
}
