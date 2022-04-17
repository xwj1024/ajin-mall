//package ajin.mall.sys.auth.handler;
//
//import ajin.mall.common.base.constant.RedisConstants;
//import ajin.mall.common.base.result.BaseResult;
//import ajin.mall.common.base.result.ResultCode;
//import ajin.mall.common.base.util.ResponseUtils;
//import ajin.mall.common.data.entity.User;
//import ajin.mall.sys.system.service.UserService;
//import org.apache.dubbo.config.annotation.Reference;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.LocalDateTime;
//
///**
// * 自定义身份验证成功处理程序
// * 登录成功处理逻辑
// *
// * @author Ajin
// * @date 2022/04/16
// */
//@Component
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Reference
//    private UserService sysUserService;
//
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = userDetails.getUsername();
//        User sysUser = sysUserService.loadUserByUsername(username);
//        // 更新用户登录时间
//        sysUser.setLoginTime(LocalDateTime.now());
//        sysUserService.updateById(sysUser);
//        // 清除redis中登录失败次数限制
//        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(RedisConstants.LOGIN_FAIL_TIMES + username))) {
//            stringRedisTemplate.delete(RedisConstants.LOGIN_FAIL_TIMES + username);
//        }
//
//        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
//        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展
//        // todo token
//
//        // 返回json数据
//        BaseResult<String> result = new BaseResult<>(ResultCode.OK, "登录成功");
//        ResponseUtils.printJson(response, result);
//    }
//}