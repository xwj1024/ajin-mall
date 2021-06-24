package cn.leemay.mall.common.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ajin
 * @since 2021-06-19
 */
public class ResponseUtils {

    public static void printJson(HttpServletResponse response, Object obj) throws IOException {
        try (PrintWriter writer = response.getWriter()) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            String json = JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue);
            writer.print(json);
            writer.flush();
        }
    }
}
