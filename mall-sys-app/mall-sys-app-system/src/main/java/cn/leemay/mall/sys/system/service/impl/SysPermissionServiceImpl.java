package cn.leemay.mall.sys.system.service.impl;

import cn.leemay.mall.common.data.entity.system.SysPermission;
import cn.leemay.mall.sys.system.mapper.SysPermissionMapper;
import cn.leemay.mall.sys.system.service.SysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ajin
 */
@org.apache.dubbo.config.annotation.Service
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<String> selectPermissionListByUser(Long sysUserId) {
        return sysPermissionMapper.selectPermissionListByUser(sysUserId);
    }

    @Override
    public List<String> selectPermissionListByPathAndMethod(String requestUrl, String requestMethod) {
        return sysPermissionMapper.selectPermissionListByPathAndMethod(requestUrl, requestMethod);
    }
}
