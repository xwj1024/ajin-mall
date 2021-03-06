package ajin.mall.sys.system.mapper;

import ajin.mall.common.data.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 许可映射器
 *
 * @author Ajin
 * @date 2022/04/21
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据用户id查询用户权限
     *
     * @param userId 用户id
     * @return 权限列表
     */
    List<String> selectPermissionListByUser(@Param("userId") Long userId);

    /**
     * 根据请求路径查询用户权限
     *
     * @param path   请求路径
     * @param method 请求方法
     * @return 权限列表
     */
    List<String> selectPermissionListByPathAndMethod(@Param("path") String path, @Param("method") String method);
}
