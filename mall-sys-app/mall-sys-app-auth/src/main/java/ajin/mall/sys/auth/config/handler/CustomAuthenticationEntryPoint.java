package ajin.mall.sys.auth.config.handler;

import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultCode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 匿名用户访问无权限资源时的异常
 *
 * @author Ajin
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        BaseResult<String> result = new BaseResult<>(ResultCode.ERR, exception.getMessage());
        String             json   = JSON.toJSONString(result, SerializerFeature.WriteMapNullValue);
        response.setContentType("application/json;charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(json);
            writer.flush();
        }
    }
}