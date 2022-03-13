//package cn.leemay.mall.common.base.interceptor;
//
//import cn.leemay.mall.common.base.util.HttpUtils;
//import cn.leemay.mall.common.base.wrapper.RepeatRequestWrapper;
//import com.alibaba.fastjson.JSON;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
///**
// * 判断请求url和数据是否和上一次相同，如果和上次相同，则是重复提交表单。有效时间为 x 秒内。
// *
// * @author Ajin
// * @since 2021-05-17
// */
//@EqualsAndHashCode(callSuper = true)
//@Data
//@Component
//@ConfigurationProperties(prefix = "repeat")
//public class SameUriDataInterceptor extends RepeatSubmitInterceptor implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    private static final String REPEAT_PARAM = "repeatParam";
//
//    private static final String REPEAT_TIME = "repeatTime";
//
//    private static final String REPEAT_KEY = "repeatKey";
//
//    private static final String HEADER = "Authorization";
//
//    private int intervalTime = 3000;
//
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public boolean isRepeatSubmit(HttpServletRequest request) {
//        String nowParam = "";
//        if (request instanceof RepeatRequestWrapper) {
//            RepeatRequestWrapper repeatedlyRequest = (RepeatRequestWrapper) request;
//            nowParam = HttpUtils.getBodyString(repeatedlyRequest);
//        }
//
//        // body参数为空，获取Parameter的数据
//        if (StringUtils.isEmpty(nowParam)) {
//            nowParam = JSON.toJSONString(request.getParameterMap());
//        }
//
//        // 获取本次请求参数及系统时间
//        Map<String, Object> nowDataMap = new HashMap<>(2);
//        nowDataMap.put(REPEAT_PARAM, JSON.toJSONString(nowParam));
//        nowDataMap.put(REPEAT_TIME, System.currentTimeMillis());
//
//        // 请求地址（作为存放cache的key值）
//        String uri = request.getRequestURI();
//
//        // 唯一值（没有请求头则使用请求地址）
//        String submitKey = request.getHeader(HEADER);
//        if (StringUtils.isEmpty(submitKey)) {
//            submitKey = uri;
//        }
//
//        // 唯一标识（指定key + 请求头）
//        String repeatSubmitKey = REPEAT_KEY + submitKey;
//        Object obj             = stringRedisTemplate.opsForValue().get(repeatSubmitKey);
//        if (obj != null) {
//            Map<String, Object> oldDataMap = JSON.parseObject(obj.toString(), Map.class);
//            if (oldDataMap.containsKey(uri)) {
//                Map<String, Object> preDataMap = (Map<String, Object>) oldDataMap.get(uri);
//                if (compareParam(nowDataMap, preDataMap) && compareTime(nowDataMap, preDataMap)) {
//                    return true;
//                }
//            }
//        }
//        Map<String, Object> newDataMap = new HashMap<>(1);
//        newDataMap.put(uri, nowDataMap);
//        stringRedisTemplate.opsForValue().set(repeatSubmitKey, JSON.toJSONString(newDataMap), intervalTime, TimeUnit.MILLISECONDS);
//        return false;
//    }
//
//    /**
//     * 判断参数是否相同
//     */
//    private boolean compareParam(Map<String, Object> nowMap, Map<String, Object> preMap) {
//        String nowParam = (String) nowMap.get(REPEAT_PARAM);
//        String preParam = (String) preMap.get(REPEAT_PARAM);
//        return nowParam.equals(preParam);
//    }
//
//    /**
//     * 判断两次间隔时间
//     */
//    private boolean compareTime(Map<String, Object> nowMap, Map<String, Object> preMap) {
//        long nowTime = (Long) nowMap.get(REPEAT_TIME);
//        long preTime = (Long) preMap.get(REPEAT_TIME);
//        return nowTime - preTime < intervalTime;
//    }
//}
