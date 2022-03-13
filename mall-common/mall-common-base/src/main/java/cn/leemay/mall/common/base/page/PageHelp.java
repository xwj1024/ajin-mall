//package cn.leemay.mall.common.base.page;
//
//import com.github.pagehelper.PageHelper;
//
///**
// * @author Ajin
// * @since 2021-04-13
// */
//public class PageHelp {
//
//    public static int pageIndexFormat(String pageIndex) {
//        int index;
//        try {
//            index = Integer.parseInt(pageIndex);
//            if (index < 1) {
//                index = 1;
//            }
//        } catch (NumberFormatException e) {
//            index = 1;
//        }
//        return index;
//    }
//
//    public static int pageSizeFormat(String pageSize) {
//        int size;
//        try {
//            size = Integer.parseInt(pageSize);
//            if (size < 1) {
//                size = 10;
//            }
//        } catch (NumberFormatException e) {
//            size = 10;
//        }
//        return size;
//    }
//
//    public static void startPage(String pageIndex, String pageSize) {
//        if (pageIndex != null || pageSize != null) {
//            int index = pageIndexFormat(pageIndex);
//            int size = pageSizeFormat(pageSize);
//            PageHelper.startPage(index, size);
//        }
//    }
//
//    public static void startPage(Integer pageIndex, Integer pageSize) {
//        if (pageIndex != null || pageSize != null) {
//            if (pageIndex == null || pageIndex <= 0) {
//                pageIndex = 1;
//            }
//            if (pageSize == null || pageSize <= 0) {
//                pageSize = 10;
//            }
//            PageHelper.startPage(pageIndex, pageSize);
//        }
//    }
//
//}
