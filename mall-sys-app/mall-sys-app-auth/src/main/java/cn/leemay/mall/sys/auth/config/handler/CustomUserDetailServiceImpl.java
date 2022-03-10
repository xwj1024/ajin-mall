package cn.leemay.mall.sys.auth.config.handler;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 自定义授权认证
 *
 * @author Ajin
 * @since 2021-05-19
 */
@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String encode = passwordEncoder.encode("1024");
        return new User("root", encode, AuthorityUtils.commaSeparatedStringToAuthorityList("root"));
    }
}
