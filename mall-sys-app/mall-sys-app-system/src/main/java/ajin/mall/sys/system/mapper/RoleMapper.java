package ajin.mall.sys.system.mapper;

import ajin.mall.common.data.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色映射器
 *
 * @author Ajin
 * @date 2022/04/21
 */
public interface RoleMapper extends BaseMapper<Role> {


    /**
     * 由用户选择角色列表
     *
     * @param userId 用户id
     * @return {@link List}<{@link String}>
     */
    List<String> selectRoleListByUser(@Param("userId") Long userId);
}
