package cn.leemay.mall.sys.system.mapper;

import cn.leemay.mall.common.data.entity.system.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 系统用户
     */
    SysUser loadUserByUsername(@Param("username") String username);
}
