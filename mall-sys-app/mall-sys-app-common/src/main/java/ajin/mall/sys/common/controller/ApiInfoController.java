package ajin.mall.sys.common.controller;

import ajin.mall.sys.common.entity.ApiInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
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
@Api(tags = "api信息")
@CrossOrigin
public class ApiInfoController {

    @Autowired
    private WebApplicationContext applicationContext;

    // todo
    @GetMapping
    public Object get() throws ClassNotFoundException {
        ServletContext servletContext = applicationContext.getServletContext();
        String contextPath = servletContext.getContextPath();

        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> mappingHandlerMethods = mapping.getHandlerMethods();

        List<ApiInfo> list = new ArrayList();

        for (Map.Entry<RequestMappingInfo, HandlerMethod> map : mappingHandlerMethods.entrySet()) {
            ApiInfo apiInfo = new ApiInfo();
            RequestMappingInfo info = map.getKey();
            HandlerMethod method = map.getValue();
            PatternsRequestCondition patternsCondition = info.getPatternsCondition();
            String className = method.getMethod().getDeclaringClass().getName();

            // 匹配包路径 根据自己的路径替换
            if (className.contains("ajin.mall")) {
                //获取类对象
                Class clazz = Class.forName(method.getMethod().getDeclaringClass().getName());
                String metName = method.getMethod().getName();
                /**
                 * 因为单独获取一个类对象要指定参数，不适合批量使用，所以获取所有的方法然后根据name筛选
                 */
                Method[] clazzDeclaredMethods = clazz.getDeclaredMethods();
                Arrays.stream(clazzDeclaredMethods).forEach(
                        c -> {
                            if (c.getName().equals(metName)) {
                                /* swagger注解 可以换成别的 */
                                ApiOperation annotation = c.getAnnotation(ApiOperation.class);
                                if (null != annotation) {
                                    apiInfo.setName(annotation.value());
                                }
                            }
                        }
                );
                for (String url : patternsCondition.getPatterns()) {
                    apiInfo.setPath(contextPath + url);
                }
                list.add(apiInfo);
            }
        }
        return list;
    }
}
