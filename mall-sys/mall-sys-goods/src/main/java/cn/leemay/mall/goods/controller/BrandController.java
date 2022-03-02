package cn.leemay.mall.goods.controller;


import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultEnum;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.form.BrandInsertForm;
import cn.leemay.mall.goods.entity.form.BrandSelectForm;
import cn.leemay.mall.goods.entity.form.BrandUpdateForm;
import cn.leemay.mall.goods.entity.view.BrandView;
import cn.leemay.mall.goods.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@Validated // todo 不知道需不需要 待测
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
    public BaseResult<BrandView> selectOne(@PathVariable("id") Long id) {
        BrandView result = brandService.selectOne(id);
        if (result == null) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询品牌")
    public BaseResult<ResultPage<BrandView>> selectList(@RequestBody BrandSelectForm brandSelectForm) {
        ResultPage<BrandView> result = brandService.selectList(brandSelectForm);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }
}

