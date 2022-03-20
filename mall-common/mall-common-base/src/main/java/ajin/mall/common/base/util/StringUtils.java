package ajin.mall.common.base.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ajin
 * @since 2021-05-21
 */
public class StringUtils {

    private static final Pattern LINE_PATTERN = Pattern.compile("_(\\w)");
    private static final Pattern HUMP_PATTERN = Pattern.compile("[A-Z]");

    /**
     * 空字符串
     */
    private static final String EMPTY_STRING = "";

    /**
     * 下划线
     */
    private static final char SEPARATOR = '_';

    /**
     * 下划线转驼峰
     */
    public static String line2Hump(String str) {
        str = str.toLowerCase();
        Matcher matcher = LINE_PATTERN.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 驼峰转下划线
     */
    public static String hump2Line(String str) {
        char[] chars = new char[1];
        chars[0] = str.charAt(0);
        String first = String.valueOf(chars[0]);
        String s = str.replaceFirst(first, first.toLowerCase());
        Matcher matcher = HUMP_PATTERN.matcher(s);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || EMPTY_STRING.equals(str.trim());
    }

    /**
     * * 判断一个字符串是否为非空串
     *
     * @param str String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }
}
