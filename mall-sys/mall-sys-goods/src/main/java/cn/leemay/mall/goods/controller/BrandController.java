package cn.leemay.mall.goods.controller;


import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultEnum;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.view.BrandView;
import cn.leemay.mall.goods.entity.form.BrandInsertForm;
import cn.leemay.mall.goods.entity.form.BrandSelectForm;
import cn.leemay.mall.goods.entity.form.BrandUpdateForm;
import cn.leemay.mall.goods.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/api/goods/brand")
@Api(tags = "品牌")
@CrossOrigin
@Validated
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加品牌")
    public BaseResult<String> insertBrand(@RequestBody @Validated BrandInsertForm brandInsertForm) {
        brandService.insertBrand(brandInsertForm);
        return new BaseResult<>(ResultEnum.INSERT_OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除品牌", notes = "根据主键id删除")
    public BaseResult<String> deleteBrand(@PathVariable("id") Long id) {
        brandService.deleteBrand(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改品牌", notes = "根据主键id修改")
    public BaseResult<String> updateBrand(@RequestBody @Validated BrandUpdateForm brandUpdateForm) {
        brandService.updateBrand(brandUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询品牌")
    public BaseResult<BrandView> selectOneById(@PathVariable("id") Long id) {
        BrandView result = brandService.selectOneById(id);
        if (result == null) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }

    @PostMapping("/selectListByCondition")
    @ApiOperation("根据条件查询品牌")
    public BaseResult<List<BrandView>> selectListByCondition(@RequestBody BrandSelectForm brandSelectForm) {
        List<BrandView> result = brandService.selectListByCondition(brandSelectForm);
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }

    @PostMapping("/selectPageByCondition/{index}/{size}")
    @ApiOperation("根据条件分页查询品牌")
    public BaseResult<ResultPage<BrandView>> selectPageByCondition(@Validated @RequestBody BrandSelectForm brandSelectForm,
                                                                   @PathVariable("index") Integer index,
                                                                   @PathVariable("size") Integer size) {
        ResultPage<BrandView> result = brandService.selectPageByCondition(brandSelectForm, index, size);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }
}

