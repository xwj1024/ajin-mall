package cn.leemay.mall.common.base.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-04-14
 */
@Component
@ConfigurationProperties(prefix = "swagger")
@Data
public class SwaggerProperties implements Serializable {
    private static final long serialVersionUID = 1L;

    private Boolean enable = true;
    private String group = "Ajin";
    private String title = "";
    private String desc = "生活如此美好,学习永无止境!";
    private String version = "0.0.1";

}
