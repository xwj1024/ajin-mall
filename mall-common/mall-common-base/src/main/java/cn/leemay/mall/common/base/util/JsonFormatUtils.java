package cn.leemay.mall.common.base.util;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author Ajin
 * @since 2021-04-13
 */
public class JsonFormatUtils {

    /**
     * 原有数据
     * [
     * "{'颜色': '黑色', '尺码': '180度'}",
     * "{'颜色': '红色', '尺码': '150度'}",
     * ]
     * <p>
     * 需要的数据格式
     * {
     * 颜色:[黑色,红色],
     * 尺码:[100度,150度]
     * }
     */

    public static Map<String, Set<String>> formatListJsonString2Map(List<String> jsonListString) {
        Map<String, Set<String>> resultMap = new HashMap<>(16);
        if (jsonListString != null && jsonListString.size() > 0) {
            for (String jsonString : jsonListString) {
                // 将json数据转换为map
                Map<String, String> jsonMap = JSON.parseObject(jsonString, Map.class);
                for (String jsonKey : jsonMap.keySet()) {
                    Set<String> jsonSet = resultMap.get(jsonKey);
                    if (jsonSet == null) {
                        jsonSet = new HashSet<>();
                    }
                    // 将值放入set中
                    jsonSet.add(jsonMap.get(jsonKey));
                    // 将set放入map中
                    resultMap.put(jsonKey, jsonSet);
                }
            }
        }
        return resultMap;
    }
}
