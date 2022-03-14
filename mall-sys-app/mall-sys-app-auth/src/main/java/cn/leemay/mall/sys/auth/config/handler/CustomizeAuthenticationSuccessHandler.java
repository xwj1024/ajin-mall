package cn.leemay.mall.sys.auth.config.handler;

import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.common.data.entity.system.SysUser;
import cn.leemay.mall.sys.system.service.SysUserService;
import com.alibaba.fastjson.JSON;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * 登录成功处理逻辑
 *
 * @author Ajin
 */
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Reference
    private SysUserService sysUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        // 更新用户登录时间
        User    userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser sysUser     = sysUserService.loadUserByUsername(userDetails.getUsername());
        sysUser.setLoginTime(LocalDateTime.now());
//        sysUserService.updateById(sysUser);

        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展
        // todo token

        // 返回json数据
        BaseResult<String> result = new BaseResult<>(ResultCode.OK, "登录成功");
        // 处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("application/json;charset=utf-8");
        // 塞到HttpServletResponse中返回给前台
        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.write(JSON.toJSONString(result));
            writer.flush();
        }
    }
}