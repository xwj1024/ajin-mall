package ajin.mall.sys.system.service.impl;

import ajin.mall.sys.system.mapper.PermissionMapper;
import ajin.mall.sys.system.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ajin
 */
@org.apache.dubbo.config.annotation.Service
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<String> selectPermissionListByUser(Long sysUserId) {
        return permissionMapper.selectPermissionListByUser(sysUserId);
    }

    @Override
    public List<String> selectPermissionListByPathAndMethod(String requestUrl, String requestMethod) {
        return permissionMapper.selectPermissionListByPathAndMethod(requestUrl, requestMethod);
    }
}
