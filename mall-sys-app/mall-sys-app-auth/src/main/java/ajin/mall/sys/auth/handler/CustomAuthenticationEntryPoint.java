//package ajin.mall.sys.auth.handler;
//
//import ajin.mall.common.base.result.BaseResult;
//import ajin.mall.common.base.result.ResultCode;
//import ajin.mall.common.base.util.ResponseUtils;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 自定义身份验证入口点
// * 匿名用户访问无权限资源时的异常
// *
// * @author Ajin
// * @date 2022/04/16
// */
//@Component
//public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        BaseResult<String> result = new BaseResult<>(ResultCode.ERR, exception.getMessage());
//        ResponseUtils.printJson(response, result);
//    }
//}