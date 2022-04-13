package ajin.mall.web.member.service.impl;

import ajin.mall.common.base.asserts.BizAssert;
import ajin.mall.common.data.entity.Member;
import ajin.mall.web.member.form.MemberUpdateForm;
import ajin.mall.web.member.mapper.MemberMapper;
import ajin.mall.web.member.service.MemberService;
import ajin.mall.web.member.view.MemberView;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 会员服务impl
 *
 * @author Ajin
 * @date 2022/04/13
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public void update(MemberUpdateForm memberUpdateForm) {
        Member existMember = memberMapper.selectById(memberUpdateForm.getId());
        BizAssert.notNull(existMember, "该会员不存在，无法修改");

        Long existMemberId = memberMapper.selectIdByUsername(memberUpdateForm.getUsername());
        BizAssert.isTrue(existMemberId == null || existMemberId.equals(memberUpdateForm.getId()), "该会员已存在");

        BeanUtils.copyProperties(memberUpdateForm, existMember);

        int affectRow = memberMapper.updateById(existMember);
        BizAssert.isTrue(affectRow == 1, "修改失败");
    }

    @Override
    public MemberView get(Long id) {
        Member existMember = memberMapper.selectById(id);
        BizAssert.notNull(existMember, "该会员不存在");

        MemberView memberView = new MemberView();
        BeanUtils.copyProperties(existMember, memberView);
        return memberView;
    }
}
