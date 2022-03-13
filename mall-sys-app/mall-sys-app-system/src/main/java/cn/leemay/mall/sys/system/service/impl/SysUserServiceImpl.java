package cn.leemay.mall.sys.system.service.impl;

import cn.leemay.mall.common.base.constant.DubboConstants;
import cn.leemay.mall.common.data.entity.system.SysUser;
import cn.leemay.mall.sys.system.mapper.SysUserMapper;
import cn.leemay.mall.sys.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.annotation.Resource;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
@DubboService(group = DubboConstants.GROUP)
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public void insert(SysUser sysUser) {
        sysUser.setId(null);
        String hashPwd = BCrypt.hashpw(sysUser.getPassword(), BCrypt.gensalt());
        sysUser.setPassword(hashPwd);
        sysUserMapper.insert(sysUser);
    }

    @Override
    public SysUser loadUserByUsername(String username) {
        return sysUserMapper.loadUserByUsername(username);
    }
}
