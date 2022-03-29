package ajin.mall.sys.goods.controller;

import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.CategoryBrandAddForm;
import ajin.mall.sys.goods.form.CategoryBrandListForm;
import ajin.mall.sys.goods.form.CategoryBrandUpdateForm;
import ajin.mall.sys.goods.service.CategoryBrandService;
import ajin.mall.sys.goods.view.CategoryBrandView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品分类，商品品牌 关联表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/categoryBrand")
@CrossOrigin
@Api(tags = "商品分类，商品品牌")
public class CategoryBrandController {

    @Resource
    private CategoryBrandService categoryBrandService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加商品分类，商品品牌")
    public BaseResult<String> add(@Validated @RequestBody CategoryBrandAddForm categoryBrandAddForm) {
        categoryBrandService.add(categoryBrandAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除商品分类，商品品牌", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        categoryBrandService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改商品分类，商品品牌", notes = "根据主键id修改")
    public BaseResult<String> update(@Validated @RequestBody CategoryBrandUpdateForm categoryBrandUpdateForm) {
        categoryBrandService.update(categoryBrandUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询商品分类，商品品牌")
    public BaseResult<CategoryBrandView> get(@PathVariable("id") Long id) {
        CategoryBrandView result = categoryBrandService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询商品分类，商品品牌")
    public BaseResult<ResultPage<CategoryBrandView>> list(@RequestBody CategoryBrandListForm categoryBrandListForm) {
        ResultPage<CategoryBrandView> result = categoryBrandService.list(categoryBrandListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

}

