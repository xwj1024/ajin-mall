package ajin.mall.sys.member.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.member.form.MemberAddForm;
import ajin.mall.sys.member.form.MemberListForm;
import ajin.mall.sys.member.form.MemberUpdateForm;
import ajin.mall.sys.member.view.MemberView;

/**
 * 会员服务
 *
 * @author Ajin
 * @date 2022/04/13
 */
public interface MemberService {

    /**
     * 添加
     *
     * @param memberAddForm 成员添加表单
     */
    void add(MemberAddForm memberAddForm);


    /**
     * 删除
     *
     * @param id id
     */
    void delete(Long id);


    /**
     * 更新
     *
     * @param memberUpdateForm 成员更新表单
     */
    void update(MemberUpdateForm memberUpdateForm);


    /**
     * 得到
     *
     * @param id id
     * @return {@link MemberView}
     */
    MemberView get(Long id);


    /**
     * 列表
     *
     * @param memberListForm 成员列表形式
     * @return {@link ResultPage}<{@link MemberView}>
     */
    ResultPage<MemberView> list(MemberListForm memberListForm);
}
