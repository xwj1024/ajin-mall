package ajin.mall.sys.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Ajin
 * @since 2021-05-07
 */
@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {

    private static final String LOGIN_URI = "/sys/auth/login";
    private static final String AUTHORIZATION = "Authorization";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        // 获取响应对象
        ServerHttpResponse response = exchange.getResponse();

        // 判断当前的请求时否为登录请求,如果是 直接放行
        if (request.getURI().getPath().contains(LOGIN_URI)) {
            // 放行
            return chain.filter(exchange);
        }
        // 获取当前的所有请求信息
        HttpHeaders headers = request.getHeaders();
        // 获取jwt令牌信息
        String token = headers.getFirst(AUTHORIZATION);
        // 判断当前令牌是否存在
        if (StringUtils.isEmpty(token)) {
            // 如果不存在,则向客户端返回错误提示信息
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        // 如果令牌存在,解析jwt令牌,判断该令牌是否合法,如果令牌不合法,则向客户端返回错误提示信息
        try {
            // 解析令牌
            //JwtUtils.parseJwt(token);
        } catch (Exception e) {
            log.warn(e.getMessage());
            // 令牌解析失败
            // 向客户端返回错误提示信息
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        // 如果令牌合法,则放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
