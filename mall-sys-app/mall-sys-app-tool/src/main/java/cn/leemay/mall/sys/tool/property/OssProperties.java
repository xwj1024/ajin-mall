package cn.leemay.mall.sys.tool.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Ajin
 * @since 2021-04-13
 */
@Component
@ConfigurationProperties(prefix = "oss")
@Data
public class OssProperties {

    private String url;
    private String key;
    private String domain;
    private String bucket;
    private String secret;

}
