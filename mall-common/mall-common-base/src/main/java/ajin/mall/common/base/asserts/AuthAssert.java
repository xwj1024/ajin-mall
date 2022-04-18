package ajin.mall.common.base.asserts;

import ajin.mall.common.base.exception.AuthException;

/**
 * @author Ajin
 * @since 2022-2-19
 */
public class AuthAssert {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new AuthException(message);
        }
    }

    public static void notTrue(boolean expression, String message) {
        if (expression) {
            throw new AuthException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new AuthException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new AuthException(message);
        }
    }
}
