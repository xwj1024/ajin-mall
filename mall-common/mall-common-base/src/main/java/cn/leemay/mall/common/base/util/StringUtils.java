package cn.leemay.mall.common.base.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ajin
 * @since 2021-05-21
 */
public class StringUtils {

    private static final Pattern LINE_PATTERN = Pattern.compile("_(\\w)");

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

    private static final Pattern HUMP_PATTERN = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下划线
     */
    public static String hump2Line(String str) {
        char[] chars = new char[1];
        chars[0]  = str.charAt(0);
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

}
