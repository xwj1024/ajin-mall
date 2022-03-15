package cn.leemay.mall.sys.auth.config.handler;

import cn.leemay.mall.common.base.asserts.BizAssert;
import cn.leemay.mall.common.base.util.StringUtils;
import cn.leemay.mall.common.data.entity.system.SysUser;
import cn.leemay.mall.sys.system.service.SysPermissionService;
import cn.leemay.mall.sys.system.service.SysUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义授权认证
 *
 * @author Ajin
 * @since 2021-05-19
 */
@Component
public class CustomUserDetailServiceImpl implements UserDetailsService {

    @Reference
    private SysUserService sysUserService;

    @Reference
    private SysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BizAssert.isTrue(StringUtils.isNotEmpty(username), "账号不能为空");
        // 根据用户名查询用户
        SysUser sysUser = sysUserService.loadUserByUsername(username);
        BizAssert.notNull(sysUser, "账号或密码不正确");
        BizAssert.notTrue(sysUser.getState() == 2, "账号已禁用");
        BizAssert.notTrue(sysUser.getState() == 4, "账号已锁定");
        BizAssert.notTrue(sysUser.getState() == 8, "账号已过期");

        // 获取该用户所拥有的权限
        List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(sysUser);
        return new User(sysUser.getUsername(), sysUser.getPassword(), sysUser.getState() == 1, sysUser.getState() == 1, sysUser.getState() == 1, sysUser.getState() == 1, grantedAuthorities);
    }

    private List<GrantedAuthority> getGrantedAuthorities(SysUser sysUser) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<String>           permissions        = sysPermissionService.selectPermissionListByUser(sysUser.getId());
        if (permissions != null && permissions.size() > 0) {
            // 声明用户授权
            permissions.forEach(permission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return grantedAuthorities;
    }


}
