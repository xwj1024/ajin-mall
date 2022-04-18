package ajin.mall.common.base.constant;

import java.io.Serializable;

/**
 * redis key 常量
 *
 * @author Ajin
 * @date 2022/04/18
 * @since 2021-04-13
 */
public class RedisConstants implements Serializable {
    private static final long serialVersionUID = 1L;

    // ---------------------------------------sys------------------------------------------

    public static final String IMAGE_PREVIEW = "mall:sys:image:preview:";
    public static final String IMAGE_DATABASE = "mall:sys:image:database:";
    public static final String CHECK_CODE_PHONE = "mall:sys:check.code:phone:";
    public static final String CHECK_CODE_LOGIN = "mall:sys:check.code:login:";

    // 失败次数

    public static final String FAIL_TIMES_LOGIN = "mall:sys:fail.times:login:";
    public static final String FAIL_TIMES_CHANGE = "mall:sys:fail.times:change:";

    // 重复提交

    public static final String REPEAT_SUBMIT_KEY = "mall:sys:repeat.submit.key:";

    // token

    public static final String SYS_TOKEN_ACCESS = "mall:sys:token:access:";
    public static final String SYS_TOKEN_REFRESH = "mall:sys:token:refresh:";

    // ---------------------------------------web--------------------------------------------

    public static final String WEB_TOKEN_ACCESS = "mall:web:token:access:";
    public static final String WEB_TOKEN_REFRESH = "mall:web:token:refresh:";

}
