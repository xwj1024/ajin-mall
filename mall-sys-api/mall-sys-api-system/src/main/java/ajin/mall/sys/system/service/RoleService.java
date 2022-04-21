package ajin.mall.sys.system.service;

import java.util.List;

/**
 * 角色服务
 *
 * @author Ajin
 * @date 2022/04/21
 */
public interface RoleService {
    /**
     * 由用户选择角色列表
     *
     * @param id id
     * @return {@link List}<{@link String}>
     */
    List<String> selectRoleListByUser(Long id);
}
