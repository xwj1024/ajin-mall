package ajin.mall.sys.common.aspect;

import ajin.mall.common.base.util.StringUtils;
import ajin.mall.common.data.entity.system.SysLog;
import ajin.mall.common.data.mapper.CommonMapper;
import ajin.mall.sys.common.anno.RecordSysLog;
import ajin.mall.sys.system.service.SysLogService;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
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
public class SysLogAspect {

    @Reference
    private SysLogService sysLogService;

    @Resource
    private CommonMapper commonMapper;

    /**
     * 处理环绕执行
     *
     * @param pjp 切点
     */
    @Around("@annotation(ajin.mall.sys.common.anno.RecordSysLog)")
    public Object doAround(ProceedingJoinPoint pjp) {
        return handleLog(pjp);
    }


    @SneakyThrows
    private Object handleLog(final ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Object result = null;

        if (method.isAnnotationPresent(RecordSysLog.class)) {
            // 数据库系统操作日志
            SysLog sysLog = new SysLog();
            sysLog.setOperateTime(LocalDateTime.now());
            // 获取注解
            RecordSysLog sysOperateLogAnno = method.getAnnotation(RecordSysLog.class);
            String       description       = sysOperateLogAnno.description();
            sysLog.setDescription(description);

            // todo 处理用户id，请求地址，请求方法
            /*sysLog.setSysUserId();
            sysLog.setRemoteIp();
            sysLog.setRequestUri();
            sysLog.setRequestMethod();*/

            // 设置方法名称
            String className = pjp.getTarget().getClass().getName();
            String methodName = pjp.getSignature().getName();
            sysLog.setMethodName(className + "." + methodName + "()");
            // 获取请求参数
            Object[] args = pjp.getArgs();
            if (args != null && args.length > 0) {
                Object arg = args[0];
                String json = JSON.toJSONString(arg);
                // 设置请求参数
                if (sysOperateLogAnno.saveRequestData()) {
                    // todo 隐藏敏感字段：密码
                    sysLog.setRequestParam(json);
                }
                Map map = JSON.parseObject(json, Map.class);
                Long id = (Long) map.get("id");
                String tableName = sysOperateLogAnno.saveSourceData().getName();
                if (!StringUtils.isEmpty(tableName)) {
                    // 设置原始数据
                    Map sourceMap = commonMapper.selectById(tableName, id);
                    String sourceDate = JSON.toJSONString(sourceMap);
                    // todo 隐藏敏感字段
                    sysLog.setSourceData(sourceDate);
                }
            }
            try {
                // 执行方法
                result = pjp.proceed();
                // 设置响应结果
                if (sysOperateLogAnno.saveResponseData()) {
                    sysLog.setResponseResult(JSON.toJSONString(result));
                }
            } catch (Throwable e) {
                sysLog.setExceptionInfo(e.getMessage());
                // 保存数据库
                sysLogService.add(sysLog);
                throw e;
            }
            // 保存数据库
            sysLogService.add(sysLog);
        }
        return result;
    }
}
