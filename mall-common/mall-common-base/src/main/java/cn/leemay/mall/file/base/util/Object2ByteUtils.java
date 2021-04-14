package cn.leemay.mall.file.base.util;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author Ajin
 * @create 2021/4/13
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
