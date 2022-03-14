package cn.leemay.mall.sys.system.service;

import cn.leemay.mall.common.data.entity.system.SysUser;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
public interface SysUserService /*extends IService<SysUser>*/ {
    /**
     * 添加系统用户
     *
     * @param sysUser 系统用户
     */
    void insert(SysUser sysUser);

    /**
     * 根据用户名获取系统用户
     *
     * @param username 用户名
     * @return 系统用户
     */
    SysUser loadUserByUsername(String username);
}
