package ajin.mall.web.common.aspect;


import ajin.mall.common.base.util.StringUtils;
import ajin.mall.common.data.entity.BizLog;
import ajin.mall.common.data.mapper.CommonMapper;
import ajin.mall.web.common.anno.RecordBizLog;
import ajin.mall.web.system.service.BizLogService;
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
 * 业务日志切面
 *
 * @author Ajin
 * @date 2022/04/15
 */
@Component
@Aspect
public class BizLogAspect {

    @Reference
    private BizLogService bizLogService;

    @Resource
    private CommonMapper commonMapper;

    /**
     * 处理环绕执行
     *
     * @param pjp 切点
     */
    @Around("@annotation(ajin.mall.web.common.anno.RecordBizLog)")
    public Object doAround(ProceedingJoinPoint pjp) {
        return handleLog(pjp);
    }


    @SneakyThrows
    private Object handleLog(final ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method          method    = signature.getMethod();
        Object          result    = null;

        if (method.isAnnotationPresent(RecordBizLog.class)) {
            // 数据库系统操作日志
            BizLog bizLog = new BizLog();
            bizLog.setOperateTime(LocalDateTime.now());
            // 获取注解
            RecordBizLog recordBizLog = method.getAnnotation(RecordBizLog.class);
            String       description  = recordBizLog.value();
            bizLog.setDescription(description);

            // todo 处理用户id，请求地址，请求方法
            /*bizLog.setSysUserId();
            bizLog.setRemoteIp();
            bizLog.setRequestUri();
            bizLog.setRequestMethod();*/

            // 设置方法名称
            String className  = pjp.getTarget().getClass().getName();
            String methodName = pjp.getSignature().getName();
            bizLog.setMethodName(className + "." + methodName + "()");
            // 获取请求参数
            Object[] args = pjp.getArgs();
            if (args != null && args.length > 0) {
                Object arg  = args[0];
                String json = JSON.toJSONString(arg);
                // 设置请求参数
                if (recordBizLog.saveRequestData()) {
                    // todo 隐藏敏感字段：密码
                    bizLog.setRequestParam(json);
                }
                Map    map   = JSON.parseObject(json, Map.class);
                Object objId = map.get("id");
                Long   id    = null;
                if (objId instanceof Long) {
                    id = (Long) objId;
                } else if (objId instanceof Integer) {
                    id = ((Integer) objId).longValue();
                }

                String tableName = recordBizLog.saveSourceData().getName();
                if (!StringUtils.isEmpty(tableName)) {
                    // 设置原始数据
                    Map    sourceMap  = commonMapper.selectById(tableName, id);
                    String sourceDate = JSON.toJSONString(sourceMap);
                    // todo 隐藏敏感字段
                    bizLog.setSourceData(sourceDate);
                }
            }
            try {
                // 执行方法
                result = pjp.proceed();
                // 设置响应结果
                if (recordBizLog.saveResponseData()) {
                    bizLog.setResponseResult(JSON.toJSONString(result));
                }
            } catch (Throwable e) {
                bizLog.setExceptionInfo(e.getMessage());
                // 保存数据库
                bizLogService.add(bizLog);
                throw e;
            }
            // 保存数据库
            bizLogService.add(bizLog);
        }
        return result;
    }
}
