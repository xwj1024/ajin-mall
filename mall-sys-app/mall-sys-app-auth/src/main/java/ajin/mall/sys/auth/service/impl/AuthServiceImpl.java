package ajin.mall.sys.auth.service.impl;

import ajin.mall.common.base.asserts.AuthAssert;
import ajin.mall.common.base.asserts.BizAssert;
import ajin.mall.common.base.constant.RedisConstants;
import ajin.mall.common.base.constant.SplitConstants;
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
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 身份验证服务impl
 *
 * @author Ajin
 * @date 2022-4-17
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SecurityProperties securityProperties;

    @Reference
    private UserService userService;


    @Override
    public LoginView login(LoginForm loginForm) {
        // 判断是否超过登录失败限制次数
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(RedisConstants.FAIL_TIMES_LOGIN + loginForm.getUsername()))) {
            String loginFailTimes = stringRedisTemplate.opsForValue().get(RedisConstants.FAIL_TIMES_LOGIN + loginForm.getUsername());
            Long   expireTime     = stringRedisTemplate.opsForValue().getOperations().getExpire(RedisConstants.FAIL_TIMES_LOGIN + loginForm.getUsername(), TimeUnit.MINUTES);
            int    count          = Integer.parseInt(loginFailTimes == null ? "0" : loginFailTimes);
            expireTime = expireTime == null ? 0 : expireTime;
            Assert.isTrue(count < securityProperties.getLoginFailTimeLimit() - 1, "登录次数已超过限制，请在" + (expireTime + 1) + "分钟后重试");
        }
        // 根据用户名查询用户信息
        User existUser = userService.loadUserByUsername(loginForm.getUsername());
        // 判断是否登录失败，记录失败次数
        if (existUser == null || !BCrypt.checkpw(loginForm.getPassword(), existUser.getPassword())) {
            int loginFailTimes   = recordFailTimes(RedisConstants.FAIL_TIMES_LOGIN + loginForm.getUsername(), securityProperties.getLoginFailAfterTime());
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
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(RedisConstants.FAIL_TIMES_LOGIN + loginForm.getUsername()))) {
            stringRedisTemplate.delete(RedisConstants.FAIL_TIMES_LOGIN + loginForm.getUsername());
        }
        // 设置token信息
        Map<String, Object> claims = new HashMap<>(16);
        claims.put("userId", existUser.getId());
        claims.put("username", existUser.getUsername());
        String accessToken  = UUID.randomUUID().toString();
        String refreshToken = UUID.randomUUID().toString();
        String jwt          = JwtUtils.generateJwt(accessToken, claims);

        String accessKey   = RedisConstants.SYS_TOKEN_ACCESS + existUser.getId() + SplitConstants.REDIS_SPLIT + accessToken;
        String refreshKey  = RedisConstants.SYS_TOKEN_REFRESH + existUser.getId() + SplitConstants.REDIS_SPLIT + refreshToken;
        String accessValue = refreshKey + SplitConstants.TOKEN_SPLIT + jwt;
        // access token  过期时间2小时
        stringRedisTemplate.opsForValue().set(accessKey, accessValue, 2L, TimeUnit.HOURS);
        // refresh token  过期时间30天
        stringRedisTemplate.opsForValue().set(refreshKey, accessKey + accessValue, 30L, TimeUnit.DAYS);

        // 返回token信息
        LoginView loginView = new LoginView();
        loginView.setAccessToken(accessToken);
        loginView.setRefreshToken(refreshToken);
        return loginView;
    }

    @Override
    public void logout(String accessToken) {
        BizAssert.isTrue(StringUtils.isNotEmpty(accessToken), "访问令牌不存在");
        Set<String> keys = stringRedisTemplate.keys(RedisConstants.SYS_TOKEN_ACCESS + "*" + accessToken);
        AuthAssert.isTrue(keys != null && !keys.isEmpty(), "访问令牌已失效");
        // 移除当前token相关信息
        String accessKey   = keys.stream().findFirst().get();
        String accessValue = stringRedisTemplate.opsForValue().get(accessKey);
        String refreshKey  = accessValue.split(SplitConstants.TOKEN_SPLIT)[0];
        stringRedisTemplate.delete(refreshKey);
        stringRedisTemplate.delete(accessKey);
    }

    @Override
    public void refresh(String refreshToken) {
        BizAssert.isTrue(StringUtils.isNotEmpty(refreshToken), "刷新令牌不存在");
        // 获取刷新令牌信息，判断是否过期
        Set<String> keys = stringRedisTemplate.keys(RedisConstants.SYS_TOKEN_REFRESH + "*" + refreshToken);
        BizAssert.isTrue(keys != null && !keys.isEmpty(), "身份已失效，请重新登录");

        String refreshKey   = keys.stream().findFirst().get();
        String refreshValue = stringRedisTemplate.opsForValue().get(refreshKey);
        String accessKey    = refreshValue.split(SplitConstants.TOKEN_SPLIT)[0];
        String accessValue  = refreshValue.split(SplitConstants.TOKEN_SPLIT)[1];
        stringRedisTemplate.opsForValue().set(accessKey, accessValue, 2L, TimeUnit.HOURS);
    }

    @Override
    public void change(ChangeForm changeForm, String accessToken) {
        // 判断是否超过修改失败限制次数
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(RedisConstants.FAIL_TIMES_CHANGE + changeForm.getUsername()))) {
            String loginFailTimes = stringRedisTemplate.opsForValue().get(RedisConstants.FAIL_TIMES_LOGIN + changeForm.getUsername());
            Long   expireTime     = stringRedisTemplate.opsForValue().getOperations().getExpire(RedisConstants.FAIL_TIMES_CHANGE + changeForm.getUsername(), TimeUnit.MINUTES);
            int    count          = Integer.parseInt(loginFailTimes == null ? "0" : loginFailTimes);
            expireTime = expireTime == null ? 0 : expireTime;
            Assert.isTrue(count < securityProperties.getChangeFailTimeLimit() - 1, "修改次数已超过限制，请在" + (expireTime + 1) + "分钟后重试");
        }
        // 根据用户名查询用户信息
        User existUser = userService.loadUserByUsername(changeForm.getUsername());
        // 判断是否原密码是否正确，记录失败次数
        if (existUser == null || !BCrypt.checkpw(changeForm.getOldPassword(), existUser.getPassword())) {
            int changeFailTimes   = recordFailTimes(RedisConstants.FAIL_TIMES_CHANGE + changeForm.getUsername(), securityProperties.getChangeFailAfterTime());
            int remainChangeTimes = securityProperties.getChangeFailTimeLimit() - changeFailTimes;
            BizAssert.isTrue(remainChangeTimes <= 3, "原始密码错误，剩余修改次数：" + remainChangeTimes);
            throw new BizException("原始密码错误");
        }
        // 修改密码
        existUser.setPassword(BCrypt.hashpw(changeForm.getNewPassword(), BCrypt.gensalt()));
        userService.updateById(existUser);
        // 修改成功清除redis中登录失败次数限制
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(RedisConstants.FAIL_TIMES_CHANGE + changeForm.getUsername()))) {
            stringRedisTemplate.delete(RedisConstants.FAIL_TIMES_CHANGE + changeForm.getUsername());
        }
        // 清除token信息
        Set<String> keys = stringRedisTemplate.keys(RedisConstants.SYS_TOKEN_ACCESS + "*" + accessToken);
        AuthAssert.isTrue(keys != null && !keys.isEmpty(), "访问令牌已失效");
        String      access      = keys.stream().findFirst().get();
        String      userId      = access.split(RedisConstants.SYS_TOKEN_ACCESS)[1].split(SplitConstants.REDIS_SPLIT)[0];
        Set<String> accessKeys  = stringRedisTemplate.keys(RedisConstants.SYS_TOKEN_ACCESS + userId + "*");
        Set<String> refreshKeys = stringRedisTemplate.keys(RedisConstants.SYS_TOKEN_REFRESH + userId + "*");
        if (refreshKeys != null && !refreshKeys.isEmpty()) {
            for (String refreshKey : refreshKeys) {
                stringRedisTemplate.delete(refreshKey);
            }
        }
        if (accessKeys != null && !accessKeys.isEmpty()) {
            for (String accessKey : accessKeys) {
                stringRedisTemplate.delete(accessKey);
            }
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
