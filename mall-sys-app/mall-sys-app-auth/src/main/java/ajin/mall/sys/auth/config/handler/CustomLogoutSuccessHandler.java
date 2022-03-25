//package ajin.mall.sys.auth.config.handler;
//
//
//import ajin.mall.common.base.result.BaseResult;
//import ajin.mall.common.base.result.ResultCode;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * 登出成功处理逻辑
// *
// * @author Ajin
// */
//@Component
//public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
//    @Override
//    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        BaseResult<String> result = new BaseResult<>(ResultCode.OK, "退出成功");
//        response.setContentType("application/json;charset=utf-8");
//        try (PrintWriter writer = response.getWriter()) {
//            writer.write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
//            writer.flush();
//        }
//    }
//}
