package ajin.mall.web.member.mapper;

import ajin.mall.common.data.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 成员映射器
 *
 * @author Ajin
 * @date 2022/04/13
 */
public interface MemberMapper extends BaseMapper<Member> {
    /**
     * 根据用户名查询数量
     *
     * @param username 用户名
     * @return 数量
     */
    Integer selectCountByUsername(@Param("username") String username);

    /**
     * 根据用户名查询id
     *
     * @param username 用户名
     * @return id
     */
    Long selectIdByUsername(String username);

}
