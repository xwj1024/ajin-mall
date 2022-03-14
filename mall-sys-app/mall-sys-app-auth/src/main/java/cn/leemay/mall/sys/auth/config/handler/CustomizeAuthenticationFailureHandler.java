package cn.leemay.mall.sys.auth.config.handler;


import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import com.alibaba.fastjson.JSON;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

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
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        // 返回json数据
        BaseResult<String> result;
        if (e instanceof AccountExpiredException) {
            // 账号过期
            result = new BaseResult<>(ResultCode.ERR, "账号已过期");
        } else if (e instanceof BadCredentialsException) {
            // 密码错误
            result = new BaseResult<>(ResultCode.ERR, "账号或密码错误");
        } else if (e instanceof CredentialsExpiredException) {
            // 密码过期
            result = new BaseResult<>(ResultCode.ERR, "密码已过期");
        } else if (e instanceof DisabledException) {
            // 账号不可用
            result = new BaseResult<>(ResultCode.ERR, "账号已被禁用");
        } else if (e instanceof LockedException) {
            // 账号锁定
            result = new BaseResult<>(ResultCode.ERR, "账号已被锁定");
        } else if (e instanceof InternalAuthenticationServiceException) {
            // 用户不存在
            result = new BaseResult<>(ResultCode.ERR, "账号不存在");
        } else {
            // 其他错误
            result = new BaseResult<>(ResultCode.ERR, "账号或密码错误");
        }
        httpServletResponse.setContentType("application/json;charset=utf-8");
        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.write(JSON.toJSONString(result));
            writer.flush();
        }
    }
}
