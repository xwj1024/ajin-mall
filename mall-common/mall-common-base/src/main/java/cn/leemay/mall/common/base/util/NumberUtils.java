package cn.leemay.mall.common.base.util;

import java.math.BigDecimal;

/**
 * @author Ajin
 * @since 2021-05-31
 */
public class NumberUtils {

    public static BigDecimal fen2Yuan(Integer fen) {
        BigDecimal bdFen = BigDecimal.valueOf(fen);
        BigDecimal bdYuan = bdFen.divide(BigDecimal.valueOf(100));
        return bdYuan;
    }

    public static BigDecimal fen2Yuan(Long fen) {
        BigDecimal bdFen = BigDecimal.valueOf(fen);
        BigDecimal bdYuan = bdFen.divide(BigDecimal.valueOf(100));
        return bdYuan;
    }
}
