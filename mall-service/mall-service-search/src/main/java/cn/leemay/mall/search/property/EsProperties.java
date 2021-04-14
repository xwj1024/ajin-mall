package cn.leemay.mall.search.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Ajin
 * @create 2021/4/14
 */
@Component
@ConfigurationProperties(prefix = "es")
@Data
public class EsProperties {

    private String host;
    private Integer port;
    private String scheme;
    private String index;
}
