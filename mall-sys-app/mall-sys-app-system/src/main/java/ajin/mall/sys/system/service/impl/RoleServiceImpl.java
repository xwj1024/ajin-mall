package ajin.mall.sys.system.service.impl;

import ajin.mall.sys.system.mapper.RoleMapper;
import ajin.mall.sys.system.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色服务impl
 *
 * @author Ajin
 * @date 2022/04/21
 */
@org.apache.dubbo.config.annotation.Service
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;


    @Override
    public List<String> selectRoleListByUser(Long id) {
        return roleMapper.selectRoleListByUser(id);
    }
}
