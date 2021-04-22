package cn.leemay.mall.common.base.util;


import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * @author Ajin
 * @since 2021-4-13
 */
public class Byte2ObjectUtils {

    public static Object byte2Object(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);

            obj = oi.readObject();

            bi.close();
            oi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
