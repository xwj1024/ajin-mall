package cn.leemay.mall.common.base.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Ajin
 * @create 2021/4/14
 */
@Component
@ConfigurationProperties(prefix = "swagger")
@Data
public class SwaggerProperties implements Serializable {
    private static final long serialVersionUID = 1L;

    Boolean enable = false;
    String group = "Ajin";
    String title = "";
    String description = "生命如此美好";
    String version = "0.0.1";

}
