package cn.leemay.mall.sys.system.service;

import cn.leemay.mall.common.data.entity.system.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author A
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 根据用户id查询用户权限
     *
     * @param sysUserId 用户id
     * @return 权限列表
     */
    List<SysPermission> selectListByUser(@Param("sysUserId") Long sysUserId);
}
