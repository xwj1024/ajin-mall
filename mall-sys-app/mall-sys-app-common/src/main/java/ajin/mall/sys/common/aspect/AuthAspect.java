package ajin.mall.sys.common.aspect;

import ajin.mall.sys.common.anno.OnlyPerm;
import ajin.mall.sys.common.anno.OnlyRole;
import ajin.mall.sys.common.anno.OnlySelf;
import ajin.mall.sys.common.context.SecurityContext;
import ajin.mall.sys.common.context.SecurityContextHolder;
import ajin.mall.sys.common.util.AuthUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 身份验证方面
 *
 * @author Ajin
 * @date 2022/04/19
 */
@Component
@Aspect
public class AuthAspect {

    private static final String POINTCUT_SIGN = "@annotation(ajin.mall.sys.common.anno.OnlyRole)" +
            "||@annotation(ajin.mall.sys.common.anno.OnlyPerm)" +
            "||@annotation(ajin.mall.sys.common.anno.OnlySelf)";

    private static final String ROOT_ROLE = "root";

    @Pointcut(POINTCUT_SIGN)
    public void pointcut() {
    }

    /**
     * 环绕切入
     *
     * @param joinPoint 切面对象
     * @return 底层方法执行后的返回值
     * @throws Throwable 底层方法抛出的异常
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 注解鉴权
        checkMethodAnnotation(joinPoint);
        try {
            // 执行原有逻辑
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        }
    }

    /**
     * 对一个Method对象进行注解检查
     */
    public void checkMethodAnnotation(ProceedingJoinPoint joinPoint) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        List<String> roles = securityContext.getRoles();
        if (roles != null && roles.contains(ROOT_ROLE)) {
            return;
        }
        
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 校验 @OnlyRole 注解
        OnlyRole onlyRole = method.getAnnotation(OnlyRole.class);
        if (onlyRole != null) {
            AuthUtil.checkRole(onlyRole);
        }

        // 校验 @OnlyPerm 注解
        OnlyPerm onlyPerm = method.getAnnotation(OnlyPerm.class);
        if (onlyPerm != null) {
            AuthUtil.checkPermission(onlyPerm);
        }

        // 校验 @OnlySelf 注解
        OnlySelf onlySelf = method.getAnnotation(OnlySelf.class);
        if (onlySelf != null) {
            AuthUtil.checkSelf(onlySelf, method, joinPoint);
        }
    }
}
