package ajin.mall.common.base.constant;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-04-13
 */
public class RedisConstants implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String IMAGE_PREVIEW = "imagePreview_";
    public static final String IMAGE_DATABASE = "imageDatabase_";
    public static final String CHECK_CODE_PHONE = "checkCodePhone_";
    public static final String CHECK_CODE_LOGIN = "checkCodeLogin_";
    public static final String LOGIN_FAIL_TIMES = "loginFailTimes_";
    public static final String REPEAT_SUBMIT_KEY = "repeatSubmitKey_";

}
