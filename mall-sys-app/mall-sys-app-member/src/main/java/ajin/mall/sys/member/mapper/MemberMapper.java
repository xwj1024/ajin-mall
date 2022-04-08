package ajin.mall.sys.member.mapper;

import ajin.mall.common.data.entity.Member;
import ajin.mall.sys.member.form.MemberListForm;
import ajin.mall.sys.member.view.MemberView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Ajin
 */
public interface MemberMapper extends BaseMapper<Member> {
    Integer selectCountByUsername(String username);

    Long selectIdByUsername(String username);

    List<MemberView> selectListByCondition(MemberListForm memberListForm);

}
