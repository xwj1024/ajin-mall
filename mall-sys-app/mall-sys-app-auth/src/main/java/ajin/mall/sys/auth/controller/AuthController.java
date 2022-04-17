package ajin.mall.sys.auth.controller;

import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultCode;
import ajin.mall.sys.auth.form.ChangeForm;
import ajin.mall.sys.auth.form.LoginForm;
import ajin.mall.sys.auth.service.AuthService;
import ajin.mall.sys.auth.view.LoginView;
import ajin.mall.sys.common.anno.RecordSysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

/**
 * 身份验证控制器
 *
 * @author Ajin
 * @date 2022/04/17
 * @since 2022-4-17
 */
@RestController
@Api(tags = "认证授权")
@CrossOrigin
@Validated
public class AuthController {

    @Resource
    private AuthService authService;

    @RepeatSubmit
    @RecordSysLog(value = "用户登录", saveRequestData = false)
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public BaseResult<LoginView> login(@Validated@RequestBody LoginForm loginForm) {
        LoginView result = authService.login(loginForm);
        return new BaseResult<>(ResultCode.OK, "登录成功", result);
    }

    // todo 仅限自己
    @RepeatSubmit
    @ApiOperation("退出登录")
    @DeleteMapping("/logout")
    public BaseResult<String> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        authService.logout(token);
        return new BaseResult<>(ResultCode.OK, "退出成功");
    }

    @RepeatSubmit
    @ApiOperation("刷新令牌")
    @PostMapping("/refresh")
    public BaseResult<String> refresh(@NotBlank(message = "刷新令牌不能为空") @RequestParam String refreshToken) {
        authService.refresh(refreshToken);
        return new BaseResult<>(ResultCode.OK, "刷新成功");
    }

    @RecordSysLog(value = "修改密码", saveRequestData = false)
    @RepeatSubmit
    @ApiOperation("修改密码")
    @PostMapping("/change")
    public BaseResult<String> change(@Validated @RequestBody ChangeForm changeForm) {
        authService.change(changeForm);
        return new BaseResult<>(ResultCode.OK, "修改成功");
    }
}
