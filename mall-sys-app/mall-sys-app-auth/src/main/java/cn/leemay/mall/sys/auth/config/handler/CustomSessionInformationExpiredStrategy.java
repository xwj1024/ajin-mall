package cn.leemay.mall.sys.auth.config.handler;

import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 会话信息过期策略
 *
 * @author Ajin
 */
@Component
public class CustomSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        BaseResult<String>  result              = new BaseResult<>(ResultCode.ERR, "账号已下线");
        HttpServletResponse httpServletResponse = sessionInformationExpiredEvent.getResponse();
        String              json                = JSON.toJSONString(result, SerializerFeature.WriteMapNullValue);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.print(json);
            writer.flush();
        }
    }
}
