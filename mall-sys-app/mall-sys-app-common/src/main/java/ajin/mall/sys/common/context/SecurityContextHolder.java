package ajin.mall.sys.common.context;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.Map;

/**
 * 安全上下文持有人
 *
 * @author Ajin
 * @date 2022/04/21
 */
public class SecurityContextHolder {

    private static final TransmittableThreadLocal<SecurityContext> THREAD_LOCAL = new TransmittableThreadLocal<>();

    public static void set(String key, Object value) {
        Map<String, Object> map = getContext();
        map.put(key, value == null ? "" : value);
    }

    public static Object get(String key) {
        Map<String, Object> map = getContext();
        return map.get(key);
    }

    public static void setContext(SecurityContext context) {
        THREAD_LOCAL.set(context);
    }

    public static SecurityContext getContext() {
        SecurityContext securityContext = THREAD_LOCAL.get();
        if (securityContext == null) {
            securityContext = new SecurityContext();
            THREAD_LOCAL.set(securityContext);
        }
        return securityContext;
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
