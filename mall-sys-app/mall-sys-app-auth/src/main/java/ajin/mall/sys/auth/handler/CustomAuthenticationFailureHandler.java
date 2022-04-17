//package ajin.mall.sys.auth.handler;
//
//import ajin.mall.common.base.constant.RedisConstants;
//import ajin.mall.common.base.result.BaseResult;
//import ajin.mall.common.base.result.ResultCode;
//import ajin.mall.common.base.util.ResponseUtils;
//import ajin.mall.common.base.util.StringUtils;
//import ajin.mall.sys.auth.property.SecurityProperties;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.security.authentication.*;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
///**
// * 登录失败处理逻辑
// *
// * @author Ajin
// * @date 2022/04/16
// */
//@Component
//public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Resource
//    private SecurityProperties securityProperties;
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        // 返回json数据
//        BaseResult<String> result;
//        if (exception instanceof AccountExpiredException) {
//            result = new BaseResult<>(ResultCode.ERR, "账号已过期");
//        } else if (exception instanceof CredentialsExpiredException) {
//            result = new BaseResult<>(ResultCode.ERR, "密码已过期");
//        } else if (exception instanceof DisabledException) {
//            result = new BaseResult<>(ResultCode.ERR, "账号已被禁用");
//        } else if (exception instanceof LockedException) {
//            result = new BaseResult<>(ResultCode.ERR, "账号已被锁定");
//        } else if (exception instanceof InternalAuthenticationServiceException) {
//            result = new BaseResult<>(ResultCode.ERR, "身份认证失败");
//        } else if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
//            // 记录登录失败次数
//            String username = request.getParameter("username");
//            int loginFailTimes = recordLoginFailTimes(username);
//            int remainLoginTimes = securityProperties.getLoginFailTimeLimit() - loginFailTimes;
//            if (remainLoginTimes <= 3) {
//                result = new BaseResult<>(ResultCode.ERR, "账号或密码错误，剩余登录次数：" + remainLoginTimes);
//            } else {
//                result = new BaseResult<>(ResultCode.ERR, "账号或密码错误");
//            }
//        } else {
//            result = new BaseResult<>(ResultCode.ERR, "登录失败");
//        }
//
//        ResponseUtils.printJson(response, result);
//    }
//
//    private int recordLoginFailTimes(String username) {
//        String loginFailTimes = stringRedisTemplate.opsForValue().get(RedisConstants.LOGIN_FAIL_TIMES + username);
//        if (StringUtils.isEmpty(loginFailTimes)) {
//            loginFailTimes = "0";
//        }
//        int newLoginFailTimes = Integer.parseInt(loginFailTimes) + 1;
//        stringRedisTemplate.opsForValue().set(RedisConstants.LOGIN_FAIL_TIMES + username, Integer.toString(newLoginFailTimes), securityProperties.getLoginFailAfterTime(), TimeUnit.MINUTES);
//        return newLoginFailTimes;
//    }
//}
