package cn.leemay.mall.sys.goods.controller;


import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultEnum;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.BrandAddForm;
import cn.leemay.mall.sys.goods.form.BrandListForm;
import cn.leemay.mall.sys.goods.form.BrandUpdateForm;
import cn.leemay.mall.sys.goods.view.BrandView;
import cn.leemay.mall.sys.goods.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/brand")
@Api(tags = "品牌")
@CrossOrigin
public class BrandController {

    @Resource
    private BrandService brandService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加品牌")
    public BaseResult<String> add(@RequestBody @Validated BrandAddForm brandAddForm) {
        brandService.add(brandAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除品牌", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        brandService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改品牌", notes = "根据主键id修改")
    public BaseResult<String> update(@RequestBody @Validated BrandUpdateForm brandUpdateForm) {
        brandService.update(brandUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询品牌")
    public BaseResult<BrandView> get(@PathVariable("id") Long id) {
        BrandView result = brandService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询品牌")
    public BaseResult<ResultPage<BrandView>> list(@RequestBody BrandListForm brandListForm) {
        ResultPage<BrandView> result = brandService.list(brandListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}

