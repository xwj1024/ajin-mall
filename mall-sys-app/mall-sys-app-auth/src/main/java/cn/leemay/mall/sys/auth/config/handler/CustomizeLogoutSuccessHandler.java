package cn.leemay.mall.sys.auth.config.handler;


import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登出成功处理逻辑
 *
 * @author Ajin
 */
@Component
public class CustomizeLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        BaseResult<String> result = new BaseResult<>(ResultCode.OK, "退出成功");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.write(JSON.toJSONString(result));
            writer.flush();
        }
    }
}
