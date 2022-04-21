package ajin.mall.sys.system.service.impl;

import ajin.mall.sys.system.mapper.PermissionMapper;
import ajin.mall.sys.system.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 许可服务impl
 *
 * @author Ajin
 * @date 2022/04/21
 */
@org.apache.dubbo.config.annotation.Service
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<String> selectPermissionListByUser(Long userId) {
        return permissionMapper.selectPermissionListByUser(userId);
    }

    @Override
    public List<String> selectPermissionListByPathAndMethod(String requestUrl, String requestMethod) {
        return permissionMapper.selectPermissionListByPathAndMethod(requestUrl, requestMethod);
    }
}
