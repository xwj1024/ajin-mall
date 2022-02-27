package cn.leemay.mall.common.base.asserts;

import cn.leemay.mall.common.base.exception.BizException;

/**
 * @author Ajin
 * @since 2022-2-19
 */
public class BizAssert {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BizException(message);
        }
    }

    public static void notTrue(boolean expression, String message) {
        if (expression) {
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
