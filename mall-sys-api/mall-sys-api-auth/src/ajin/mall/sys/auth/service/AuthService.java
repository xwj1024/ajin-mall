package ajin.mall.sys.auth.service;

import ajin.mall.sys.auth.form.ChangeForm;
import ajin.mall.sys.auth.form.LoginForm;
import ajin.mall.sys.auth.view.LoginView;

/**
 * 身份验证服务
 *
 * @author Ajin
 * @since 2022-4-17
 */
public interface AuthService {

    /**
     * 登录
     *
     * @param loginForm 登录表单
     * @return {@link LoginView}
     */
    LoginView login(LoginForm loginForm);

    /**
     * 注销
     *
     * @param token 令牌
     */
    void logout(String token);

    /**
     * 刷新
     *
     * @param refreshToken 刷新令牌
     */
    void refresh(String refreshToken);

    /**
     * 修改密码
     *
     * @param changeForm 改变形式
     */
    void change(ChangeForm changeForm);
}
