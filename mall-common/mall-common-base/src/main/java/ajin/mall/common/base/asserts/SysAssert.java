package ajin.mall.common.base.asserts;

import ajin.mall.common.base.exception.SysException;

/**
 * @author Ajin
 * @since 2022-2-19
 */
public class SysAssert {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new SysException(message);
        }
    }

    public static void notTrue(boolean expression, String message) {
        if (expression) {
            throw new SysException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new SysException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new SysException(message);
        }
    }
}
