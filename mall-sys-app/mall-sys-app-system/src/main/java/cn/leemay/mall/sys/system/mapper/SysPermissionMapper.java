package cn.leemay.mall.sys.system.mapper;

import cn.leemay.mall.common.data.entity.system.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ajin
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 根据用户id查询用户权限
     *
     * @param sysUserId 用户id
     * @return 权限列表
     */
    List<String> selectPermissionListByUser(@Param("sysUserId") Long sysUserId);
}
