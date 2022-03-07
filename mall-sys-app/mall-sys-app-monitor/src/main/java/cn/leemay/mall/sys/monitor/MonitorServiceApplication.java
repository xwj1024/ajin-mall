package cn.leemay.mall.sys.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Ajin
 * @since 2021-10-13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MonitorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitorServiceApplication.class, args);
    }
}