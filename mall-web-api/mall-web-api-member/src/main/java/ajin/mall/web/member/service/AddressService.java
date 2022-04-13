package ajin.mall.web.member.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.web.member.form.AddressAddForm;
import ajin.mall.web.member.form.AddressListForm;
import ajin.mall.web.member.form.AddressUpdateForm;
import ajin.mall.web.member.view.AddressView;

/**
 * 地址服务
 *
 * @author Ajin
 * @date 2022/04/13
 */
public interface AddressService {

    /**
     * 添加
     *
     * @param addressAddForm 地址添加表单
     */
    void add(AddressAddForm addressAddForm);

    /**
     * 删除
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 更新
     *
     * @param addressUpdateForm 地址更新表单
     */
    void update(AddressUpdateForm addressUpdateForm);

    /**
     * 得到
     *
     * @param id id
     * @return {@link AddressView}
     */
    AddressView get(Long id);

    /**
     * 列表
     *
     * @param addressListForm 地址列表形式
     * @return {@link ResultPage}<{@link AddressView}>
     */
    ResultPage<AddressView> list(AddressListForm addressListForm);
}
