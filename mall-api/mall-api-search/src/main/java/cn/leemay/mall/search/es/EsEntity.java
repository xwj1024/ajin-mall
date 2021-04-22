package cn.leemay.mall.search.es;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-04-14
 */
@Data
public class EsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 索引的_id，不指定则使用es自动生成的
     */
    private String id;

    /**
     * 不转中间对象，直接转为json字符串,避免批量插入浪费内存资源
     */
    private String jsonData;

    /**
     * 将任意类型对象转为EsEntity
     * 不指定_id
     *
     * @param obj 一个文档（记录）
     * @param <T>
     * @return
     */
    public static <T> EsEntity obj2EsEntity(T obj) {
        return obj2EsEntity(null, obj);
    }

    /**
     * 将任意类型对象转为EsEntity
     *
     * @param id  是null:不指定_id，非null：指定_id
     * @param obj 一个文档（记录）
     * @param <T>
     * @return
     */
    public static <T> EsEntity obj2EsEntity(String id, T obj) {
        EsEntity esEntity = new EsEntity();
        String data = JSON.toJSONString(obj);
        esEntity.setId(id);
        esEntity.setJsonData(data);
        return esEntity;
    }

}
