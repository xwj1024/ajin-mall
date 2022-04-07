package ajin.mall.sys.system.service.impl;

import ajin.mall.sys.system.form.UserAddForm;
import ajin.mall.sys.system.mapper.UserMapper;
import ajin.mall.sys.system.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
@org.apache.dubbo.config.annotation.Service
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void add(UserAddForm userAddForm) {
        User user = new User();
        BeanUtils.copyProperties(userAddForm, user);
        String hashPwd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashPwd);
        userMapper.insert(user);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userMapper.loadUserByUsername(username);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }


}
