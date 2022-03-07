package cn.leemay.mall.sys.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * @author Ajin
 * @since 2021-4-15
 */
@Component
public class IpFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("经过了第一个过滤器...");
        ServerHttpRequest request = exchange.getRequest();
        InetSocketAddress remoteAddress = request.getRemoteAddress();
        if (remoteAddress != null) {
            String hostName = remoteAddress.getHostName();
            System.out.println("IP: " + hostName);
        }
        // 放行
        return chain.filter(exchange);
    }

    /**
     * 过滤器执行优先级
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
