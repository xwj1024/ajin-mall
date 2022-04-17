package ajin.mall.sys.auth.service.impl;

import ajin.mall.common.base.asserts.BizAssert;
import ajin.mall.common.base.constant.RedisConstants;
import ajin.mall.common.base.exception.BizException;
import ajin.mall.common.base.util.JwtUtils;
import ajin.mall.common.base.util.StringUtils;
import ajin.mall.common.data.entity.User;
import ajin.mall.sys.auth.form.ChangeForm;
import ajin.mall.sys.auth.form.LoginForm;
import ajin.mall.sys.auth.property.SecurityProperties;
import ajin.mall.sys.auth.service.AuthService;
import ajin.mall.sys.auth.view.LoginView;
import ajin.mall.sys.system.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 身份验证服务impl
 *
 * @author Ajin
 * @date 2022-4-17
 */
@Service
public class AuthServiceImpl implements AuthService {

    private static final String TOKEN_SEPARATOR = ",";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SecurityProperties securityProperties;

    @Reference
    private UserService userService;


    @Override
    public LoginView login(LoginForm loginForm) {
        // 判断是否超过登录失败限制次数
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(RedisConstants.LOGIN_FAIL_TIMES + loginForm.getUsername()))) {
            String loginFailTimes = stringRedisTemplate.opsForValue().get(RedisConstants.LOGIN_FAIL_TIMES + loginForm.getUsername());
            Long expireTime = stringRedisTemplate.opsForValue().getOperations().getExpire(RedisConstants.LOGIN_FAIL_TIMES + loginForm.getUsername(), TimeUnit.MINUTES);
            int count = Integer.parseInt(loginFailTimes == null ? "0" : loginFailTimes);
            expireTime = expireTime == null ? 0 : expireTime;
            Assert.isTrue(count < securityProperties.getLoginFailTimeLimit() - 1, "登录次数已超过限制，请在" + (expireTime + 1) + "分钟后重试");
        }
        // 根据用户名查询用户信息
        User existUser = userService.loadUserByUsername(loginForm.getUsername());
        // 判断是否登录失败，记录失败次数
        if (existUser == null || !BCrypt.checkpw(loginForm.getPassword(), existUser.getPassword())) {
            int loginFailTimes = recordFailTimes(RedisConstants.LOGIN_FAIL_TIMES + loginForm.getUsername(), securityProperties.getLoginFailAfterTime());
            int remainLoginTimes = securityProperties.getLoginFailTimeLimit() - loginFailTimes;
            BizAssert.isTrue(remainLoginTimes > 3, "账号或密码错误，剩余登录次数：" + remainLoginTimes);
            throw new BizException("账号或密码错误");
        }
        // 判断账号状态
        BizAssert.notTrue(existUser.getState() == 2, "账号已被禁用");
        BizAssert.notTrue(existUser.getState() == 4, "账号已被锁定");
        BizAssert.notTrue(existUser.getState() == 8, "账号已过期");
        BizAssert.notTrue(existUser.getState() == 16, "密码已过期");
        // 登录成功，更新登录时间
        existUser.setLoginTime(LocalDateTime.now());
        userService.updateById(existUser);
        // 登录成功清除redis中登录失败次数限制
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(RedisConstants.LOGIN_FAIL_TIMES + loginForm.getUsername()))) {
            stringRedisTemplate.delete(RedisConstants.LOGIN_FAIL_TIMES + loginForm.getUsername());
        }
        // 设置token信息
        Map<String, Object> claims = new HashMap<>(16);
        claims.put("userId", existUser.getId());
        claims.put("username", existUser.getUsername());
        String accessTokenKey = UUID.randomUUID().toString();
        String accessTokenValue = JwtUtils.generateJwt(accessTokenKey, claims);
        String refreshTokenKey = UUID.randomUUID().toString();
        String refreshTokenValue = accessTokenKey + TOKEN_SEPARATOR + accessTokenValue;
        // access token 过期时间2小时
        stringRedisTemplate.opsForValue().set(RedisConstants.SYS_TOKEN_ACCESS + accessTokenKey,
                refreshTokenKey + TOKEN_SEPARATOR + accessTokenValue, 2L, TimeUnit.HOURS);
        // refresh token 过期时间30天
        stringRedisTemplate.opsForValue().set(RedisConstants.SYS_TOKEN_REFRESH + refreshTokenKey,
                refreshTokenValue, 30L, TimeUnit.DAYS);

        // 返回token信息
        LoginView loginView = new LoginView();
        loginView.setAccessToken(accessTokenKey);
        loginView.setRefreshToken(refreshTokenKey);
        return loginView;
    }

    @Override
    public void logout(String token) {
        BizAssert.isTrue(StringUtils.isNotEmpty(token), "访问令牌不存在");
        String accessTokenValue = stringRedisTemplate.opsForValue().get(RedisConstants.SYS_TOKEN_ACCESS + token);
        BizAssert.notNull(accessTokenValue, "token异常");
        String refreshTokenKey = accessTokenValue.split(TOKEN_SEPARATOR)[0];
        stringRedisTemplate.delete(refreshTokenKey);
        stringRedisTemplate.delete(token);
    }

    @Override
    public void refresh(String refreshToken) {
        BizAssert.isTrue(StringUtils.isNotEmpty(refreshToken), "刷新令牌不存在");
        // 获取刷新令牌信息，判断是否过期
        String refreshTokenValue = stringRedisTemplate.opsForValue().get(RedisConstants.SYS_TOKEN_REFRESH + refreshToken);
        BizAssert.notNull(refreshTokenValue, "token无效");
        String accessTokenKey = refreshTokenValue.split(TOKEN_SEPARATOR)[0];
        String accessTokenValue = refreshTokenValue.split(TOKEN_SEPARATOR)[1];
        stringRedisTemplate.opsForValue().set(RedisConstants.SYS_TOKEN_ACCESS + accessTokenKey,
                refreshToken + TOKEN_SEPARATOR + accessTokenValue, 2L, TimeUnit.HOURS);
    }

    @Override
    public void change(ChangeForm changeForm) {
        // 判断是否超过修改失败限制次数
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(RedisConstants.CHANGE_FAIL_TIMES + changeForm.getUsername()))) {
            String loginFailTimes = stringRedisTemplate.opsForValue().get(RedisConstants.LOGIN_FAIL_TIMES + changeForm.getUsername());
            Long expireTime = stringRedisTemplate.opsForValue().getOperations().getExpire(RedisConstants.CHANGE_FAIL_TIMES + changeForm.getUsername(), TimeUnit.MINUTES);
            int count = Integer.parseInt(loginFailTimes == null ? "0" : loginFailTimes);
            expireTime = expireTime == null ? 0 : expireTime;
            Assert.isTrue(count < securityProperties.getChangeFailTimeLimit() - 1, "修改次数已超过限制，请在" + (expireTime + 1) + "分钟后重试");
        }
        // 根据用户名查询用户信息
        User existUser = userService.loadUserByUsername(changeForm.getUsername());
        // 判断是否原密码是否正确，记录失败次数
        if (existUser == null || !BCrypt.checkpw(changeForm.getOldPassword(), existUser.getPassword())) {
            int changeFailTimes = recordFailTimes(RedisConstants.CHANGE_FAIL_TIMES + changeForm.getUsername(), securityProperties.getChangeFailAfterTime());
            int remainChangeTimes = securityProperties.getChangeFailTimeLimit() - changeFailTimes;
            BizAssert.isTrue(remainChangeTimes <= 3, "原始密码错误，剩余修改次数：" + remainChangeTimes);
            throw new BizException("原始密码错误");
        }
        // 修改密码
        existUser.setPassword(BCrypt.hashpw(changeForm.getNewPassword(), BCrypt.gensalt()));
        userService.updateById(existUser);
        // 修改成功清除redis中登录失败次数限制
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(RedisConstants.CHANGE_FAIL_TIMES + changeForm.getUsername()))) {
            stringRedisTemplate.delete(RedisConstants.CHANGE_FAIL_TIMES + changeForm.getUsername());
        }
    }

    private int recordFailTimes(String key, Integer time) {
        String failTimes = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(failTimes)) {
            failTimes = "0";
        }
        int newFailTimes = Integer.parseInt(failTimes) + 1;
        stringRedisTemplate.opsForValue().set(key, Integer.toString(newFailTimes), time, TimeUnit.MINUTES);
        return newFailTimes;
    }
}
