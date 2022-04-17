//package ajin.mall.sys.auth.handler;
//
//import ajin.mall.common.base.asserts.BizAssert;
//import ajin.mall.common.base.constant.RedisConstants;
//import ajin.mall.common.base.util.StringUtils;
//import ajin.mall.common.data.entity.User;
//import ajin.mall.sys.auth.property.SecurityProperties;
//import ajin.mall.sys.system.service.PermissionService;
//import ajin.mall.sys.system.service.UserService;
//import org.apache.dubbo.config.annotation.Reference;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 自定义授权认证
// *
// * @author Ajin
// * @since 2021-05-19
// */
//@Component
//public class CustomUserDetailServiceImpl implements UserDetailsService {
//
//    @Reference
//    private UserService sysUserService;
//
//    @Reference
//    private PermissionService sysPermissionService;
//
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Resource
//    private SecurityProperties securityProperties;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        BizAssert.isTrue(StringUtils.isNotEmpty(username), "账号不能为空");
//
//        // 获取登录失败次数
//        String key = RedisConstants.LOGIN_FAIL_TIMES + username;
//        String value = stringRedisTemplate.opsForValue().get(key);
//        if (StringUtils.isNotEmpty(value)) {
//            // 超过限制次数
//            BizAssert.isTrue(Integer.parseInt(value) >= securityProperties.getLoginFailTimeLimit(),
//                    "登录错误次数超过限制，请" + securityProperties.getLoginFailAfterTime() + "分钟后再试");
//        }
//
//        // 根据用户名查询用户
//        User sysUser = sysUserService.loadUserByUsername(username);
//        BizAssert.notNull(sysUser, "账号不存在");
//        // 获取用户状态信息
//        Integer state = sysUser.getState();
//
//        // 获取该用户所拥有的权限
//        List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(sysUser);
//
//        return new org.springframework.security.core.userdetails.User(sysUser.getUsername(), sysUser.getPassword(),
//                state == 1,
//                state != 8,
//                state != 16,
//                state != 4,
//                grantedAuthorities);
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(User sysUser) {
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        List<String> permissions = sysPermissionService.selectPermissionListByUser(sysUser.getId());
//        if (permissions != null && permissions.size() > 0) {
//            // 声明用户授权
//            permissions.forEach(permission -> {
//                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
//                grantedAuthorities.add(grantedAuthority);
//            });
//        }
//        return grantedAuthorities;
//    }
//}
