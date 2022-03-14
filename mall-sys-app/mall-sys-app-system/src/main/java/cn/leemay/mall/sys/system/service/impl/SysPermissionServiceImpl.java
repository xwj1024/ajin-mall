package cn.leemay.mall.sys.system.service.impl;

import cn.leemay.mall.common.base.constant.DubboConstants;
import cn.leemay.mall.common.data.entity.system.SysPermission;
import cn.leemay.mall.sys.system.mapper.SysPermissionMapper;
import cn.leemay.mall.sys.system.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ajin
 */
@org.apache.dubbo.config.annotation.Service(group = DubboConstants.GROUP)
@Service
public class SysPermissionServiceImpl /*extends ServiceImpl<SysPermissionMapper, SysPermission>*/ implements SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> selectListByUser(Long sysUserId) {
        return sysPermissionMapper.selectListByUser(sysUserId);
    }
}
