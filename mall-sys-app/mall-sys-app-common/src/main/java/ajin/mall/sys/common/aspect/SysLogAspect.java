package ajin.mall.sys.common.aspect;

import ajin.mall.common.base.util.StringUtils;
import ajin.mall.common.data.entity.SysLog;
import ajin.mall.common.data.mapper.CommonMapper;
import ajin.mall.sys.common.anno.RecordSysLog;
import ajin.mall.sys.common.context.SecurityContext;
import ajin.mall.sys.common.context.SecurityContextHolder;
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
            RecordSysLog recordSysLog = method.getAnnotation(RecordSysLog.class);
            String description = recordSysLog.value();
            sysLog.setDescription(description);

            SecurityContext securityContext = SecurityContextHolder.getContext();
            sysLog.setUserId(securityContext.getUserId());
            sysLog.setRemoteIp(securityContext.getRemoteIp());
            sysLog.setRequestUri(securityContext.getRequestUri());
            sysLog.setRequestMethod(securityContext.getRequestMethod());

            // 设置方法名称
            String className = pjp.getTarget().getClass().getName();
            String methodName = pjp.getSignature().getName();
            sysLog.setMethodName(className + "." + methodName + "()");
            // 获取请求参数
            Object[] args = pjp.getArgs();
            if (args != null && args.length > 0 && args[0] != null) {
                Object arg = args[0];
                String json = JSON.toJSONString(arg);

                // 设置请求参数
                if (recordSysLog.saveRequestData()) {
                    // 隐藏敏感字段
                    Map requestMap = JSON.parseObject(json, Map.class);
                    hideSensitiveInfo(requestMap);
                    String requestParam = JSON.toJSONString(requestMap);
                    sysLog.setRequestParam(requestParam);
                }
                // 设置原始数据
                String tableName = recordSysLog.saveSourceData().getName();
                if (!StringUtils.isEmpty(tableName)) {
                    Map map = JSON.parseObject(json, Map.class);
                    Object objId = map.get("id");
                    Long id = objId == null ? null : Long.valueOf(String.valueOf(objId));
                    if (id != null) {
                        Map sourceMap = commonMapper.selectById(tableName, id);
                        // 隐藏敏感字段
                        hideSensitiveInfo(sourceMap);
                        String sourceDate = JSON.toJSONString(sourceMap);
                        sysLog.setSourceData(sourceDate);
                    }
                }
            }
            try {
                // 执行方法
                result = pjp.proceed();
                // 设置响应结果
                if (recordSysLog.saveResponseData()) {
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

    private static final String[] SENSITIVE_FIELDS = {"password", "oldPassword", "newPassword"};

    private void hideSensitiveInfo(Map map) {
        for (String field : SENSITIVE_FIELDS) {
            map.replace(field, "???");
        }
    }
}
