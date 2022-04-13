package ajin.mall.web.member.controller;

import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.web.member.form.AddressAddForm;
import ajin.mall.web.member.form.AddressListForm;
import ajin.mall.web.member.form.AddressUpdateForm;
import ajin.mall.web.member.service.AddressService;
import ajin.mall.web.member.view.AddressView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Ajin
 */
@RestController
@RequestMapping("/address")
@Api(tags = "收件地址")
@CrossOrigin
public class AddressController {

    @Resource
    private AddressService addressService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加地址")
    public BaseResult<String> add(@Validated @RequestBody AddressAddForm addressAddForm) {
        addressService.add(addressAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除地址", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        addressService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改地址", notes = "根据主键id修改")
    public BaseResult<String> update(@Validated @RequestBody AddressUpdateForm addressUpdateForm) {
        addressService.update(addressUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询地址")
    public BaseResult<AddressView> get(@PathVariable("id") Long id) {
        AddressView result = addressService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询地址")
    public BaseResult<ResultPage<AddressView>> list(@RequestBody AddressListForm addressListForm) {
        ResultPage<AddressView> result = addressService.list(addressListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}
