package ajin.mall.sys.goods.controller;


import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.common.data.enums.TableInfo;
import ajin.mall.sys.common.anno.RecordSysLog;
import ajin.mall.sys.goods.form.BrandAddForm;
import ajin.mall.sys.goods.form.BrandListForm;
import ajin.mall.sys.goods.form.BrandUpdateForm;
import ajin.mall.sys.goods.service.BrandService;
import ajin.mall.sys.goods.view.BrandView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品品牌表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/brand")
@Api(tags = "商品品牌")
@CrossOrigin
public class BrandController {

    @Resource
    private BrandService brandService;

    @RecordSysLog(description = "添加商品品牌")
    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加商品品牌")
    public BaseResult<String> add(@Validated @RequestBody BrandAddForm brandAddForm) {
        brandService.add(brandAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除商品品牌", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        brandService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RecordSysLog(description = "修改商品品牌", saveSourceData = TableInfo.BRAND)
    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改商品品牌", notes = "根据主键id修改")
    public BaseResult<String> update(@Validated @RequestBody BrandUpdateForm brandUpdateForm) {
        brandService.update(brandUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询商品品牌")
    public BaseResult<BrandView> get(@PathVariable("id") Long id) {
        BrandView result = brandService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询商品品牌")
    public BaseResult<ResultPage<BrandView>> list(@RequestBody BrandListForm brandListForm) {
        ResultPage<BrandView> result = brandService.list(brandListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}

