package cn.leemay.mall.sys.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Ajin
 * @since 2021-05-13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SysMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysMemberApplication.class, args);
    }
}
