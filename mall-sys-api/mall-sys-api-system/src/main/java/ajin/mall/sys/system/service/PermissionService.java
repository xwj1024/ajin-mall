package ajin.mall.sys.system.service;

import java.util.List;

/**
 * @author Ajin
 */
public interface PermissionService {

    /**
     * 根据用户id查询用户权限
     *
     * @param userId 用户id
     * @return 权限列表
     */
    List<String> selectPermissionListByUser(Long userId);

    /**
     * 根据请求路径，请求方法 查询用户权限
     *
     * @param requestUrl    请求路径
     * @param requestMethod 请求方法
     * @return 权限列表
     */
    List<String> selectPermissionListByPathAndMethod(String requestUrl, String requestMethod);
}
