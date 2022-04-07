package ajin.mall.sys.system.service;

import ajin.mall.common.data.entity.User;
import ajin.mall.sys.system.form.UserAddForm;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
public interface UserService {
    /**
     * 添加系统用户
     *
     * @param userAddForm 系统用户
     */
    void add(UserAddForm userAddForm);

    /**
     * 根据用户名获取系统用户
     *
     * @param username 用户名
     * @return 系统用户
     */
    User loadUserByUsername(String username);

    /**
     * 根据id修改系统用户
     *
     * @param user 系统用户修改信息
     */
    void updateById(User user);
}
