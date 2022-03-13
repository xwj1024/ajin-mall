package cn.leemay.mall.sys.system;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Ajin
 * @since 2021-05-13
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class SysSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysSystemApplication.class, args);
    }
}
