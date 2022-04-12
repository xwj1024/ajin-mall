package ajin.mall.sys.member.service.impl;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.member.form.AddressAddForm;
import ajin.mall.sys.member.form.AddressListForm;
import ajin.mall.sys.member.form.AddressUpdateForm;
import ajin.mall.sys.member.service.AddressService;
import ajin.mall.sys.member.view.AddressView;
import org.springframework.stereotype.Service;

/**
 * @author Ajin
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public void add(AddressAddForm addressAddForm) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(AddressUpdateForm addressUpdateForm) {

    }

    @Override
    public AddressView get(Long id) {
        return null;
    }

    @Override
    public ResultPage<AddressView> list(AddressListForm addressListForm) {
        return null;
    }
}
