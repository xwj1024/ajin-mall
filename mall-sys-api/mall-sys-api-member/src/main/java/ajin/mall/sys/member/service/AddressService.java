package ajin.mall.sys.member.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.member.form.AddressAddForm;
import ajin.mall.sys.member.form.AddressListForm;
import ajin.mall.sys.member.form.AddressUpdateForm;
import ajin.mall.sys.member.view.AddressView;

/**
 * @author Ajin
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
