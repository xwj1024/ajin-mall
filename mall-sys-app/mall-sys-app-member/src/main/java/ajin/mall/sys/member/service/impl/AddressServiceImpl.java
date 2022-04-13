package ajin.mall.sys.member.service.impl;

import ajin.mall.common.base.asserts.BizAssert;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.common.data.anno.CascadeDelete;
import ajin.mall.common.data.entity.Address;
import ajin.mall.common.data.enums.TableInfo;
import ajin.mall.sys.member.form.AddressAddForm;
import ajin.mall.sys.member.form.AddressListForm;
import ajin.mall.sys.member.form.AddressUpdateForm;
import ajin.mall.sys.member.mapper.AddressMapper;
import ajin.mall.sys.member.service.AddressService;
import ajin.mall.sys.member.view.AddressView;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * impl地址服务
 *
 * @author Ajin
 * @date 2022/04/13
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public void add(AddressAddForm addressAddForm) {
        // 判断是否是默认地址
        if (addressAddForm.getIsDefault() == 1) {
            // 如果是默认地址，将该用户下的其他地址改为非默认地址
            addressMapper.updateIsDefaultByMemberId(addressAddForm.getMemberId(), 0);
        }
        Address address = new Address();
        BeanUtils.copyProperties(addressAddForm, address);

        int affectRow = addressMapper.insert(address);
        BizAssert.isTrue(affectRow == 1, "添加失败");
    }

    @CascadeDelete(TableInfo.ADDRESS)
    @Override
    public void delete(Long id) {
        Address existAddress = addressMapper.selectById(id);
        BizAssert.notNull(existAddress, "该地址不存在");

        int affectRow = addressMapper.deleteById(id);
        BizAssert.isTrue(affectRow == 1, "删除失败");
    }

    @Override
    public void update(AddressUpdateForm addressUpdateForm) {
        Address existAddress = addressMapper.selectById(addressUpdateForm.getId());
        BizAssert.notNull(existAddress, "该地址不存在，无法修改");

        // 判断是否是默认地址
        if (addressUpdateForm.getIsDefault() != null && addressUpdateForm.getIsDefault() == 1) {
            // 如果是默认地址，将该用户下的其他地址改为非默认地址
            addressMapper.updateIsDefaultByMemberId(existAddress.getMemberId(), 0);
        }

        BeanUtils.copyProperties(addressUpdateForm, existAddress);

        int affectRow = addressMapper.updateById(existAddress);
        BizAssert.isTrue(affectRow == 1, "修改失败");
    }

    @Override
    public AddressView get(Long id) {
        Address existAddress = addressMapper.selectById(id);
        BizAssert.notNull(existAddress, "该地址不存在");

        AddressView addressView = new AddressView();
        BeanUtils.copyProperties(existAddress, addressView);
        return addressView;
    }

    @Override
    public ResultPage<AddressView> list(AddressListForm addressListForm) {
        return null;
    }
}
