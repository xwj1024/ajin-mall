package cn.leemay.mall.common.base.util;

import com.alibaba.fastjson.JSON;

import java.io.*;
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
    public static byte[] obj2Byte(Object obj) throws IOException {
        byte[] bytes;
        try (ByteArrayOutputStream bo = new ByteArrayOutputStream(); ObjectOutputStream oo = new ObjectOutputStream(bo)) {

            oo.writeObject(obj);
            bytes = bo.toByteArray();
        }
        return bytes;
    }

    /**
     * 字节数组转对象
     *
     * @param bytes 字节数组
     * @return 对象
     */
    public static Object byte2Obj(byte[] bytes) throws IOException, ClassNotFoundException {
        Object obj;
        try (ByteArrayInputStream bi = new ByteArrayInputStream(bytes); ObjectInputStream oi = new ObjectInputStream(bi)) {

            obj = oi.readObject();
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

    /**
     * 将对象转换为Map，将key驼峰转为下划线
     *
     * @param obj 对象
     * @return map
     */
    public static Map obj2LineMap(Object obj) {
        Map<String, Object> map = ObjectUtils.obj2Map(obj);
        String[] newKeys = ClassUtils.getColumns(obj.getClass());
        for (String newKey : newKeys) {
            map.put(newKey, map.remove(StringUtils.line2Hump(newKey)));
        }
        return map;
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

}
