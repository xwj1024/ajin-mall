package cn.leemay.mall.common.base.interceptor;

import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.common.base.anno.RepeatSubmit;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.lang.NonNull;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 防止重复提交拦截器
 *
 * @author ruoyi
 * @since 2021-05-17
 */
public abstract class RepeatSubmitInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RepeatSubmit annotation = method.getAnnotation(RepeatSubmit.class);
            if (annotation != null) {
                if (this.isRepeatSubmit(request)) {
                    BaseResult<Object> result = new BaseResult<>(ResultCode.ERR, "不允许重复操作，请稍后再试");
                    response.setContentType("application/json");
                    String json = JSON.toJSONString(result, SerializerFeature.WriteMapNullValue);
                    response.getWriter().print(json);
                    return false;
                }
            }
        }
        return super.preHandle(request, response, handler);
    }

    /**
     * 验证是否重复提交由子类实现具体的防重复提交的规则
     *
     * @param request 请求
     * @return 是否是重复提交
     * @throws Exception 异常
     */
    public abstract boolean isRepeatSubmit(HttpServletRequest request) throws Exception;
}
