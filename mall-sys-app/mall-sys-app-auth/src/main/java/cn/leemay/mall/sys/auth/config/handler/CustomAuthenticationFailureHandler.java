package cn.leemay.mall.sys.auth.config.handler;


import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录失败处理逻辑
 *
 * @author Ajin
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 限制用户登陆错误次数（次）
     */
    @Value("${security.loginTimesLimit}")
    private Integer loginTimesLimit;
    /**
     * 错误超过次数后多少分钟后才能继续登录（分钟）
     */
    @Value("${security.loginAfterTime}")
    private Integer loginAfterTime;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 返回json数据
        BaseResult<String> result;
        if (exception instanceof AccountExpiredException) {
            result = new BaseResult<>(ResultCode.ERR, "账号已过期");
        } else if (exception instanceof CredentialsExpiredException) {
            result = new BaseResult<>(ResultCode.ERR, "密码已过期");
        } else if (exception instanceof DisabledException) {
            result = new BaseResult<>(ResultCode.ERR, "账号已被禁用");
        } else if (exception instanceof LockedException) {
            result = new BaseResult<>(ResultCode.ERR, "账号已被锁定");
        } else if (exception instanceof InternalAuthenticationServiceException) {
            result = new BaseResult<>(ResultCode.ERR, "身份认证失败");
        } else if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
            // 记录登录失败次数
            String username = request.getParameter("username");
            recordLoginFailTimes(username);

            result = new BaseResult<>(ResultCode.ERR, "账号或密码错误");
        } else {
            result = new BaseResult<>(ResultCode.ERR, "登录失败");
        }

        response.setContentType("application/json;charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
            writer.flush();
        }
    }

    private void recordLoginFailTimes(String username) {

    }
}
