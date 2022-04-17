package ajin.mall.common.base.constant;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-04-13
 */
public class RedisConstants implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String IMAGE_PREVIEW = "image:preview:";
    public static final String IMAGE_DATABASE = "image:database:";
    public static final String CHECK_CODE_PHONE = "check.code:phone:";
    public static final String CHECK_CODE_LOGIN = "check.code:login:";
    public static final String LOGIN_FAIL_TIMES = "login.fail.times:";
    public static final String CHANGE_FAIL_TIMES = "change.fail.times:";
    public static final String REPEAT_SUBMIT_KEY = "repeat.submit.key:";

    public static final String WEB_TOKEN_ACCESS = "web:token:access:";
    public static final String WEB_TOKEN_REFRESH = "web:token:refresh:";

    public static final String SYS_TOKEN_ACCESS = "sys:token:access:";
    public static final String SYS_TOKEN_REFRESH = "sys:token:refresh:";

}
