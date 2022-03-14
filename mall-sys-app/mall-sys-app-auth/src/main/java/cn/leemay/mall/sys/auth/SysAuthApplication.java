package cn.leemay.mall.sys.auth;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Ajin
 * @since 2021-05-16
 */
@EnableDubbo
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SysAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysAuthApplication.class, args);
    }
}
