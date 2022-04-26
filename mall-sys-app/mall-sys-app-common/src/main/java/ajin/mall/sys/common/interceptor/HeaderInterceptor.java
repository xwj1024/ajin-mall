package ajin.mall.sys.common.interceptor;

import ajin.mall.common.base.asserts.AuthAssert;
import ajin.mall.common.base.constant.RedisConstants;
import ajin.mall.common.base.constant.SplitConstants;
import ajin.mall.common.base.exception.AuthException;
import ajin.mall.common.base.util.JwtUtils;
import ajin.mall.sys.common.context.SecurityContext;
import ajin.mall.sys.common.context.SecurityContextHolder;
import io.jsonwebtoken.Claims;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

import static ajin.mall.common.base.constant.HeaderConstants.AUTHORIZATION;

/**
 * 头拦截器
 *
 * @author Ajin
 * @date 2022/04/21
 */
@Component
public class HeaderInterceptor implements AsyncHandlerInterceptor {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            String token = request.getHeader(AUTHORIZATION);
            String accessValue = stringRedisTemplate.opsForValue().get(RedisConstants.SYS_TOKEN_ACCESS + token);
            if (accessValue != null) {
                String jwt = accessValue.split(SplitConstants.TOKEN_SPLIT)[1];
                Claims claims = JwtUtils.parseJwt(jwt);
                String userId = String.valueOf(claims.get("userId"));
                Set<String> keys = stringRedisTemplate.opsForZSet().range(RedisConstants.SYS_TOKEN_USER + userId, 0, -1);
                AuthAssert.isTrue(keys != null && keys.contains(RedisConstants.SYS_TOKEN_ACCESS + token), null);

                Object username = claims.get("username");
                Object roles = claims.get("roles");
                Object permissions = claims.get("permissions");
                String ip = request.getRemoteAddr();
                String uri = request.getRequestURI();
                String method = request.getMethod();
                // 设置安全上下文信息
                SecurityContext securityContext = new SecurityContext();
                securityContext.setUserId(Long.valueOf(userId));
                securityContext.setUsername((String) username);
                securityContext.setRoles((List<String>) roles);
                securityContext.setPermissions((List<String>) permissions);
                securityContext.setRemoteIp(ip);
                securityContext.setRequestUri(uri);
                securityContext.setRequestMethod(method);
                SecurityContextHolder.setContext(securityContext);
            }
        } catch (Exception e) {
            throw new AuthException("令牌无效");
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        SecurityContextHolder.remove();
    }
}
