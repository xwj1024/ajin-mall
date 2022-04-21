package ajin.mall.common.base.property;

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

    private String title = "";
    private String description = "永无bug！";
    private String version = "0.0.1";
    private String termsOfServiceUrl = "https://github.com/xwj1024/ajin-mall";
    private String license = "Apache 2.0";
    private String licenseUrl = "https://www.apache.org/licenses/LICENSE-2.0";
    private String contactName = "Ajin";
    private String contactUrl = "https://github.com/xwj1024/ajin-mall";
    private String contactEmail = "xwj1024@yeah.net";

}
