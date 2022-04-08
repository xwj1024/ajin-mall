package ajin.mall.sys.member.mapper;

import ajin.mall.common.data.entity.Member;
import ajin.mall.sys.member.form.MemberListForm;
import ajin.mall.sys.member.view.MemberView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ajin
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

    /**
     * 根据条件查询
     *
     * @param memberListForm 查询条件
     * @return 会员列表
     */
    List<MemberView> selectListByCondition(MemberListForm memberListForm);

}
