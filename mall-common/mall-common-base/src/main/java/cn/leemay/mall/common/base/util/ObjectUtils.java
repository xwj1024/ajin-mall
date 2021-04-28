package cn.leemay.mall.common.base.util;

import com.alibaba.fastjson.JSON;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * @author Ajin
 * @since 2021-04-27
 */
public class ObjectUtils {

    /**
     * 对象转字节数组
     *
     * @param obj 对象
     * @return 字节数组
     */
    public static byte[] obj2Byte(Object obj) {
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

    /**
     * 字节数组转对象
     *
     * @param bytes 字节数组
     * @return 对象
     */
    public static Object byte2Obj(byte[] bytes) {
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

    /**
     * 将 Map 转换为 对象
     *
     * @param map map
     * @param obj 对象
     * @return 对象
     */
    public static Object map2Obj(Map map, Class<Object> obj) {
        return JSON.parseObject(JSON.toJSONString(map), obj);
    }

    /**
     * 将 对象 转换为 Map
     *
     * @param obj 对象
     * @return map
     */
    public static Map obj2Map(Object obj) {
        return JSON.parseObject(JSON.toJSONString(obj), Map.class);
    }

}
