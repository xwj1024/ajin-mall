package cn.leemay.mall.tool;

import cn.leemay.mall.common.base.anno.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Ajin
 * @since 2021-04-14
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableSwagger
@EnableDiscoveryClient
public class ToolServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToolServiceApplication.class, args);
    }
}
