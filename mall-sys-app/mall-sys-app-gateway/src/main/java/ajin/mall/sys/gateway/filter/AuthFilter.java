package ajin.mall.sys.gateway.filter;

import ajin.mall.common.base.asserts.AuthAssert;
import ajin.mall.common.base.constant.RedisConstants;
import ajin.mall.common.base.constant.SplitConstants;
import ajin.mall.common.base.util.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Set;

import static ajin.mall.common.base.constant.HeaderConstants.AUTHORIZATION;

/**
 * @author Ajin
 * @since 2021-05-07
 */
@Component
@Slf4j
public class AuthFilter implements GlobalFilter, Ordered {

    private static final String LOGIN_URI = "/sys/auth/login";
    private static final String REFRESH_URI = "/sys/auth/refresh";
    private static final String SWAGGER_URI = "/v3/api-docs";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        // 获取响应对象
        ServerHttpResponse response = exchange.getResponse();

        // 判断当前的请求时否为登录请求,如果是 直接放行
        String path = request.getURI().getPath();
        if (path.contains(LOGIN_URI)
                || path.contains(REFRESH_URI)
                || path.contains(SWAGGER_URI)) {
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
            String accessValue = stringRedisTemplate.opsForValue().get(token);
            AuthAssert.notNull(accessValue, "令牌已失效");
            // 解析令牌
            Claims      claims = JwtUtils.parseJwt(accessValue.split(SplitConstants.TOKEN_SPLIT)[1]);
            String      userId = claims.getId();
            Set<String> keys   = stringRedisTemplate.opsForZSet().range(RedisConstants.SYS_TOKEN_USER + userId, 0, -1);
            AuthAssert.notNull(keys, "身份已失效，请重新登录");
            AuthAssert.isTrue(keys.contains(RedisConstants.SYS_TOKEN_ACCESS + token), "令牌已失效");
            // todo 设置本地线程变量

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
        return -1000;
    }
}
