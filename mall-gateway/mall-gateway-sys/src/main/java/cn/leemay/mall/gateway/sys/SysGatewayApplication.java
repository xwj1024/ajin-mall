package cn.leemay.mall.gateway.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author Ajin
 * @since 2021-04-15
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SysGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysGatewayApplication.class, args);
    }

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName());
    }
}
