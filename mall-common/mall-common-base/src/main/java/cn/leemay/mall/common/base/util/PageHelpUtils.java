package cn.leemay.mall.common.base.util;

import com.github.pagehelper.PageHelper;

/**
 * @author Ajin
 * @create 2021/4/13
 */
public class PageHelpUtils {

    public static int pageIndexFormat(String pageIndex) {
        int index;
        try {
            index = Integer.parseInt(pageIndex);
            if (index < 1) {
                index = 1;
            }
        } catch (NumberFormatException e) {
            index = 1;
        }
        return index;
    }

    public static int pageSizeFormat(String pageSize) {
        int size;
        try {
            size = Integer.parseInt(pageSize);
            if (size < 1) {
                size = 10;
            }
        } catch (NumberFormatException e) {
            size = 10;
        }
        return size;
    }

    public static void startPage(String pageIndex, String pageSize) {
        if (pageIndex != null || pageSize != null) {
            int index = pageIndexFormat(pageIndex);
            int size = pageSizeFormat(pageSize);
            PageHelper.startPage(index, size);
        }
    }

}
