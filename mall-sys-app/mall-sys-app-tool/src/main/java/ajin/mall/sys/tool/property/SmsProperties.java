package ajin.mall.sys.tool.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Ajin
 * @since 2021-05-06
 */
@Component
@ConfigurationProperties(prefix = "sms")
@Data
public class SmsProperties {

    private String key;
    private String secret;
    private String sign;
    private String template;
    private Long expire = 600L;
}
