package ajin.mall.sys.system.service;

import ajin.mall.common.data.entity.system.SysUser;
import ajin.mall.sys.system.form.SysUserAddForm;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
public interface SysUserService {
    /**
     * 添加系统用户
     *
     * @param sysUserAddForm 系统用户
     */
    void add(SysUserAddForm sysUserAddForm);

    /**
     * 根据用户名获取系统用户
     *
     * @param username 用户名
     * @return 系统用户
     */
    SysUser loadUserByUsername(String username);

}
