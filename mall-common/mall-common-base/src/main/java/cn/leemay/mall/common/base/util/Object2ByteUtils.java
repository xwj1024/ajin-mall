package cn.leemay.mall.common.base.util;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author Ajin
 * @since 2021-04-13
 */
public class Object2ByteUtils {

    public static byte[] objectToByte(Object obj) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);

            bytes = bo.toByteArray();

            bo.close();
            oo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
