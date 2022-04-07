package ajin.mall.sys.member.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.member.form.MemberAddForm;
import ajin.mall.sys.member.form.MemberListForm;
import ajin.mall.sys.member.form.MemberUpdateForm;
import ajin.mall.sys.member.view.MemberView;

/**
 * @author Ajin
 */
public interface MemberService {
    /**
     * 添加会员
     *
     * @param memberAddForm 添加表单
     */
    void add(MemberAddForm memberAddForm);

    /**
     * 删除会员
     *
     * @param id 会员id
     */
    void delete(Long id);

    /**
     * 修改会员
     *
     * @param memberUpdateForm 修改表单
     */
    void update(MemberUpdateForm memberUpdateForm);

    /**
     * 查询会员
     *
     * @param id 会员id
     * @return 会员信息
     */
    MemberView get(Long id);

    /**
     * 根据条件查询会员
     *
     * @param memberListForm 查询条件
     * @return 会员信息列表
     */
    ResultPage<MemberView> list(MemberListForm memberListForm);
}
