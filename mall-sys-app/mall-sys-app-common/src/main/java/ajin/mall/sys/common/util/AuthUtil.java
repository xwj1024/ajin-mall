package ajin.mall.sys.common.util;

import ajin.mall.common.base.asserts.AuthAssert;
import ajin.mall.common.base.exception.AuthException;
import ajin.mall.sys.common.anno.OnlyPerm;
import ajin.mall.sys.common.anno.OnlyRole;
import ajin.mall.sys.common.anno.OnlySelf;
import ajin.mall.sys.common.context.SecurityContext;
import ajin.mall.sys.common.context.SecurityContextHolder;
import ajin.mall.sys.common.enums.Logical;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * auth跑龙套
 *
 * @author Ajin
 * @date 2022/04/21
 */
public class AuthUtil {

    /**
     * 根据注解传入参数鉴权
     *
     * @param onlyRole 角色权限注解
     */
    public static void checkRole(OnlyRole onlyRole) {
        if (onlyRole.logical() == Logical.AND) {
            checkRoleAnd(onlyRole.value());
        } else {
            checkRoleOr(onlyRole.value());
        }
    }

    private static void checkRoleAnd(String[] value) {
        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            List<String> roles = securityContext.getRoles();
            AuthAssert.isTrue(new HashSet<>(roles).containsAll(Arrays.asList(value)), null);
        } catch (Exception e) {
            throw new AuthException("无权限访问");
        }
    }

    private static void checkRoleOr(String[] value) {
        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            List<String> roles = securityContext.getRoles();
            for (String role : value) {
                if (roles.contains(role)) {
                    return;
                }
            }
            throw new AuthException();
        } catch (Exception e) {
            throw new AuthException("无权限访问");
        }
    }

    /**
     * 根据注解传入参数鉴权
     *
     * @param onlyPerm 权限注解
     */
    public static void checkPermission(OnlyPerm onlyPerm) {
        if (onlyPerm.logical() == Logical.AND) {
            checkPermissionAnd(onlyPerm.value());
        } else {
            checkPermissionOr(onlyPerm.value());
        }
    }

    private static void checkPermissionAnd(String[] value) {
        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            List<String> permissions = securityContext.getPermissions();
            AuthAssert.isTrue(new HashSet<>(permissions).containsAll(Arrays.asList(value)), null);
        } catch (Exception e) {
            throw new AuthException("无权限访问");
        }
    }

    private static void checkPermissionOr(String[] value) {
        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            List<String> permissions = securityContext.getPermissions();
            for (String permission : value) {
                if (permissions.contains(permission)) {
                    return;
                }
            }
            throw new AuthException();
        } catch (Exception e) {
            throw new AuthException("无权限访问");
        }
    }

    public static void checkSelf(OnlySelf onlySelf, Method method, ProceedingJoinPoint joinPoint) {
        try {
            ExpressionParser parser = new SpelExpressionParser();
            // 获取方法的参数值
            Object[] args = joinPoint.getArgs();
            EvaluationContext context = bindParam(method, args);
            // 根据spel表达式获取值
            Expression expression = parser.parseExpression(onlySelf.param());
            Object key = expression.getValue(context);

            SecurityContext securityContext = SecurityContextHolder.getContext();
            Class<? extends SecurityContext> clazz = securityContext.getClass();
            Object value;
            try {
                Field field = clazz.getDeclaredField(onlySelf.claim());
                field.setAccessible(true);
                value = field.get(securityContext);
            } catch (NoSuchFieldException e) {
                value = securityContext.get(onlySelf.claim());
            }
            AuthAssert.isTrue(value != null && String.valueOf(value).equals(String.valueOf(key)), null);
        } catch (Exception e) {
            throw new AuthException("无权限访问");
        }
    }

    private static final LocalVariableTableParameterNameDiscoverer DISCOVERER = new LocalVariableTableParameterNameDiscoverer();

    private static EvaluationContext bindParam(Method method, Object[] args) {
        // 获取方法的参数名
        String[] params = DISCOVERER.getParameterNames(method);

        // 将参数名与参数值对应起来
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < Objects.requireNonNull(params).length; len++) {
            context.setVariable(params[len], args[len]);
        }
        return context;
    }
}
