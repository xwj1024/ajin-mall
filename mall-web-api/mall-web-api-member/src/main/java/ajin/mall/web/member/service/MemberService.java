package ajin.mall.web.member.service;

import ajin.mall.web.member.form.MemberUpdateForm;
import ajin.mall.web.member.view.MemberView;

/**
 * 会员服务
 *
 * @author Ajin
 * @date 2022/04/13
 */
public interface MemberService {

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

}
