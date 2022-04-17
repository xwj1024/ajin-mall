//package ajin.mall.sys.auth.handler;
//
//import ajin.mall.sys.system.service.PermissionService;
//import org.apache.dubbo.config.annotation.Reference;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.List;
//
///**
// * 自定义过滤器调用安全元数据来源
// *
// * @author Ajin
// * @date 2022/04/16
// */
//@Component
//public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
//
//    @Reference
//    private PermissionService sysPermissionService;
//
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
//        // 获取请求地址，请求方法
//        String requestUrl = ((FilterInvocation) o).getRequestUrl();
//        String requestMethod     = ((FilterInvocation) o).getRequest().getMethod();
//        // 查询具体某个接口的权限
//        List<String> permissions = sysPermissionService.selectPermissionListByPathAndMethod(requestUrl,requestMethod);
//        if (permissions == null || permissions.size() == 0) {
//            // 请求路径没有配置权限，表明该请求接口可以任意访问
//            return null;
//        }
//        String[] attributes = new String[permissions.size()];
//        for (int i = 0; i < permissions.size(); i++) {
//            attributes[i] = permissions.get(i);
//        }
//        return SecurityConfig.createList(attributes);
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return true;
//    }
//}
