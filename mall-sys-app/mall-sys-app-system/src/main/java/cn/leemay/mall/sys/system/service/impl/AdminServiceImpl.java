package cn.leemay.mall.sys.system.service.impl;

import cn.leemay.mall.common.data.entity.system.Admin;
import cn.leemay.mall.sys.system.mapper.AdminMapper;
import cn.leemay.mall.sys.system.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
@Service
@org.apache.dubbo.config.annotation.Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void insert(Admin admin) {
        admin.setId(null);
        String hashPwd = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt());
        admin.setPassword(hashPwd);
        adminMapper.insert(admin);
    }
}
