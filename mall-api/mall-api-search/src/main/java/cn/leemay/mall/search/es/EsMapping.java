package cn.leemay.mall.search.es;

import cn.leemay.mall.search.anno.EsField;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于代码创建索引
 *
 * @author Ajin
 * @since 2021-04-14
 */
@Data
public class EsMapping implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean dynamic = false;
    private Map<String, Map<String, Object>> properties;

    /**
     * 生成索引字段映射信息
     *
     * @param dynamic
     * @param type
     * @return
     */
    public static EsMapping byType(boolean dynamic, Class<?> type) {
        EsMapping esMapping = new EsMapping();
        esMapping.setDynamic(dynamic);
        esMapping.setProperties(new HashMap<>(4));
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Map<String, Object> value = new HashMap<>(4);
            EsField esField = field.getDeclaredAnnotation(EsField.class);
            if (esField != null) {
                if ("text".equals(esField.type())) {
                    value.put("type", esField.type());
                    value.put("index", esField.index());
                    value.put("analyzer", esField.analyzer());
                } else {
                    value.put("type", esField.type());
                    value.put("index", esField.index());
                }
                esMapping.getProperties().put(field.getName(), value);
            }
        }
        return esMapping;
    }

}