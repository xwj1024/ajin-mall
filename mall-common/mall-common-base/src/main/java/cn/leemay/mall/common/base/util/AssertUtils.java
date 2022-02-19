package cn.leemay.mall.common.base.util;

import cn.leemay.mall.common.base.exception.BizException;

/**
 * @author Ajin
 * @since 2022-2-19
 */
public class AssertUtils {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BizException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new BizException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new BizException(message);
        }
    }
}
