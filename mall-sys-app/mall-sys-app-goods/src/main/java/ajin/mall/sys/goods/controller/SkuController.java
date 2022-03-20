package ajin.mall.sys.goods.controller;


import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.common.data.entity.goods.Sku;
import ajin.mall.sys.goods.form.SkuAddForm;
import ajin.mall.sys.goods.form.SkuListForm;
import ajin.mall.sys.goods.form.SkuUpdateForm;
import ajin.mall.sys.goods.service.SkuService;
import ajin.mall.sys.goods.view.SkuView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品sku表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/sku")
@Api(tags = "商品sku")
@CrossOrigin
public class SkuController {

    @Resource
    private SkuService skuService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加sku")
    public BaseResult<String> add(@Validated @RequestBody SkuAddForm skuAddForm) {
        skuService.add(skuAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除sku")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        skuService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation("修改sku")
    public BaseResult<String> update(@Validated @RequestBody SkuUpdateForm skuUpdateForm) {
        skuService.update(skuUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询sku")
    public BaseResult<Sku> get(@PathVariable("id") Long id) {
        Sku result = skuService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询Sku")
    public BaseResult<ResultPage<SkuView>> list(@RequestBody SkuListForm skuListForm) {
        ResultPage<SkuView> result = skuService.list(skuListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}

