package cn.leemay.mall.search.config;


import cn.leemay.mall.search.property.EsProperties;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Ajin
 * @since 2021-04-14
 */
@Configuration
public class EsConfig {

    @Autowired
    private EsProperties esProperties;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestClientBuilder restClientBuilder = RestClient.builder(
                new HttpHost(esProperties.getHost(), esProperties.getPort(), esProperties.getScheme()));
        return new RestHighLevelClient(restClientBuilder);
    }

}
