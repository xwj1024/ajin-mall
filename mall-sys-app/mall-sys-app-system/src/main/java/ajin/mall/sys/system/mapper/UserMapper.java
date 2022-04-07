package ajin.mall.sys.system.mapper;

import ajin.mall.common.data.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 系统用户
     */
    User loadUserByUsername(@Param("username") String username);
}
