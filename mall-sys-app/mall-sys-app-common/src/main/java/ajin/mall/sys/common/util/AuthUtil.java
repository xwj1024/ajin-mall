package ajin.mall.sys.common.util;

import ajin.mall.common.base.asserts.AuthAssert;
import ajin.mall.common.base.exception.AuthException;
import ajin.mall.sys.common.anno.OnlyPermission;
import ajin.mall.sys.common.anno.OnlyRole;
import ajin.mall.sys.common.context.SecurityContextHolder;
import ajin.mall.sys.common.enums.Logical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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
            Object       rolesObj = SecurityContextHolder.get("roles");
            List<String> roles    = (List<String>) rolesObj;
            AuthAssert.isTrue(new HashSet<>(roles).containsAll(Arrays.asList(value)), null);
        } catch (Exception e) {
            throw new AuthException("无权限访问");
        }
    }

    private static void checkRoleOr(String[] value) {
        try {
            Object       rolesObj = SecurityContextHolder.get("roles");
            List<String> roles    = (List<String>) rolesObj;
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
     * @param onlyPermission 权限注解
     */
    public static void checkPermission(OnlyPermission onlyPermission) {
        if (onlyPermission.logical() == Logical.AND) {
            checkPermissionAnd(onlyPermission.value());
        } else {
            checkPermissionOr(onlyPermission.value());
        }
    }

    private static void checkPermissionAnd(String[] value) {
        try {
            Object       permissionsObj = SecurityContextHolder.get("permissions");
            List<String> permissions    = (List<String>) permissionsObj;
            AuthAssert.isTrue(new HashSet<>(permissions).containsAll(Arrays.asList(value)), null);
        } catch (Exception e) {
            throw new AuthException("无权限访问");
        }
    }

    private static void checkPermissionOr(String[] value) {
        try {
            Object       permissionsObj = SecurityContextHolder.get("permissions");
            List<String> permissions    = (List<String>) permissionsObj;
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

}
