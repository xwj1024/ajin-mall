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

    private String host = "localhost";
    private Integer port = 9200;
    private String scheme = "http";
    private String index = "";
    private Integer shards = 5;
    private Integer replicas = 1;
}
