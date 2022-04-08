package ajin.mall.sys.member.service.impl;

import ajin.mall.common.base.asserts.BizAssert;
import ajin.mall.common.base.page.PageHelp;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.common.data.anno.CascadeDelete;
import ajin.mall.common.data.entity.Member;
import ajin.mall.common.data.enums.TableInfo;
import ajin.mall.sys.member.form.MemberAddForm;
import ajin.mall.sys.member.form.MemberListForm;
import ajin.mall.sys.member.form.MemberUpdateForm;
import ajin.mall.sys.member.mapper.MemberMapper;
import ajin.mall.sys.member.service.MemberService;
import ajin.mall.sys.member.view.MemberView;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ajin
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public void add(MemberAddForm memberAddForm) {
        Integer memberCount = memberMapper.selectCountByUsername(memberAddForm.getUsername());
        BizAssert.isTrue(memberCount <= 0, "该会员已存在");

        Member member = new Member();
        BeanUtils.copyProperties(memberAddForm, member);
        int row = memberMapper.insert(member);
        BizAssert.isTrue(row == 1, "添加失败");
    }
    @CascadeDelete(TableInfo.MEMBER)
    @Override
    public void delete(Long id) {
        Member existMember = memberMapper.selectById(id);
        BizAssert.notNull(existMember, "该会员不存在");

        int row = memberMapper.deleteById(id);
        BizAssert.isTrue(row == 1, "删除失败");
    }

    @Override
    public void update(MemberUpdateForm memberUpdateForm) {
        Member existMember = memberMapper.selectById(memberUpdateForm.getId());
        BizAssert.notNull(existMember, "该会员不存在，无法修改");

        Long existMemberId = memberMapper.selectIdByUsername(memberUpdateForm.getUsername());
        BizAssert.isTrue(existMemberId == null || existMemberId.equals(memberUpdateForm.getId()), "该会员已存在");

        BeanUtils.copyProperties(memberUpdateForm, existMember);

        int row = memberMapper.updateById(existMember);
        BizAssert.isTrue(row == 1, "修改失败");
    }

    @Override
    public MemberView get(Long id) {
        Member member = memberMapper.selectById(id);
        BizAssert.notNull(member, "该会员不存在");

        MemberView memberView = new MemberView();
        BeanUtils.copyProperties(member, memberView);
        return memberView;
    }

    @Override
    public ResultPage<MemberView> list(MemberListForm memberListForm) {
        PageHelp.startPage(memberListForm.getPageIndex(), memberListForm.getPageSize());
        List<MemberView> list = memberMapper.selectListByCondition(memberListForm);
        return new ResultPage<>(new PageInfo<>(list));
    }
}
