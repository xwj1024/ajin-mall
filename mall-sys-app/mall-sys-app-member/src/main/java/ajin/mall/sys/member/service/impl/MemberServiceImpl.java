package ajin.mall.sys.member.service.impl;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.member.form.MemberAddForm;
import ajin.mall.sys.member.form.MemberListForm;
import ajin.mall.sys.member.form.MemberUpdateForm;
import ajin.mall.sys.member.service.MemberService;
import ajin.mall.sys.member.view.MemberView;
import org.springframework.stereotype.Service;

/**
 * @author Ajin
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public void add(MemberAddForm memberAddForm) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(MemberUpdateForm memberUpdateForm) {

    }

    @Override
    public MemberView get(Long id) {
        return null;
    }

    @Override
    public ResultPage<MemberView> list(MemberListForm memberListForm) {
        return null;
    }
}
