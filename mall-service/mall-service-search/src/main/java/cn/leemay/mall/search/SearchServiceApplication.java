package cn.leemay.mall.search;

import cn.leemay.mall.common.base.anno.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Ajin
 * @create 2021/4/14
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableSwagger
public class SearchServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);
    }
}
