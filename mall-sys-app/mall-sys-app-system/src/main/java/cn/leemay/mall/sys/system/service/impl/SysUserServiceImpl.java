package cn.leemay.mall.sys.system.service.impl;

import cn.leemay.mall.common.data.entity.system.SysUser;
import cn.leemay.mall.sys.system.form.SysUserAddForm;
import cn.leemay.mall.sys.system.mapper.SysUserMapper;
import cn.leemay.mall.sys.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public void add(SysUserAddForm sysUserAddForm) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserAddForm, sysUser);
        String hashPwd = BCrypt.hashpw(sysUser.getPassword(), BCrypt.gensalt());
        sysUser.setPassword(hashPwd);
        sysUserMapper.insert(sysUser);
    }

    @Override
    public SysUser loadUserByUsername(String username) {
        return sysUserMapper.loadUserByUsername(username);
    }
}
