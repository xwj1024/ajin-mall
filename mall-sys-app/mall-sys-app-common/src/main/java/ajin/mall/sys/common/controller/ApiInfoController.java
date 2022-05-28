package ajin.mall.sys.common.controller;

import ajin.mall.sys.common.entity.ApiInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 所有api控制器
 *
 * @author Ajin
 * @date 2022/04/27
 */
@RestController
@RequestMapping("/apiInfo")
@Api(tags = "接口信息")
@CrossOrigin
public class ApiInfoController {

    @Autowired
    private WebApplicationContext applicationContext;

    @GetMapping
    public List<ApiInfo> get() throws ClassNotFoundException {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> mappingHandlerMethods = mapping.getHandlerMethods();

        List<ApiInfo> list = new ArrayList();
        // 获取项目路径
        ServletContext servletContext = applicationContext.getServletContext();
        String contextPath = "";
        if (servletContext != null) {
            contextPath = servletContext.getContextPath();
        }

        for (Map.Entry<RequestMappingInfo, HandlerMethod> map : mappingHandlerMethods.entrySet()) {
            ApiInfo apiInfo = new ApiInfo();

            RequestMappingInfo info = map.getKey();
            HandlerMethod method = map.getValue();

            String className = method.getMethod().getDeclaringClass().getName();
            // 匹配包路径 根据自己的路径替换
            if (className.contains("ajin.mall")) {
                // 设置请求路径
                PatternsRequestCondition patternsCondition = info.getPatternsCondition();
                Set<String> requestUrls = patternsCondition.getPatterns();
                Optional<String> firstRequestUrl = requestUrls.stream().findFirst();
                if (firstRequestUrl.isPresent()) {
                    String requestUrl = firstRequestUrl.get();
                    if (requestUrl.contains("/apiInfo")) {
                        continue;
                    }
                    apiInfo.setPath(contextPath + requestUrl);
                }

                // 设置请求方法
                RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
                Set<RequestMethod> requestMethods = methodsCondition.getMethods();
                Optional<RequestMethod> firstRequestMethod = requestMethods.stream().findFirst();
                if (firstRequestMethod.isPresent()) {
                    RequestMethod requestMethod = firstRequestMethod.get();
                    String requestMethodName = requestMethod.name();
                    apiInfo.setMethod(requestMethodName);
                }

                // 获取类对象
                Class<?> clazz = Class.forName(method.getMethod().getDeclaringClass().getName());
                String methodName = method.getMethod().getName();

                // 设置关键字
                apiInfo.setKeyword(method.toString());

                // 因为单独获取一个类对象要指定参数，不适合批量使用，所以获取所有的方法然后根据name筛选
                Method[] clazzDeclaredMethods = clazz.getDeclaredMethods();
                Arrays.stream(clazzDeclaredMethods).forEach(m -> {
                    if (m.getName().equals(methodName)) {
                        // swagger注解 可以换成别的
                        ApiOperation annotation = m.getAnnotation(ApiOperation.class);
                        if (null != annotation) {
                            // 设置请求名称
                            apiInfo.setName(annotation.value());
                        }
                    }
                });

                list.add(apiInfo);
            }
        }
        return list;
    }
}
