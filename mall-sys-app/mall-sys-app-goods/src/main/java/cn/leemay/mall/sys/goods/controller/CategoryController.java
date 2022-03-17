package cn.leemay.mall.sys.goods.controller;


import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultEnum;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.CategoryAddForm;
import cn.leemay.mall.sys.goods.form.CategoryListForm;
import cn.leemay.mall.sys.goods.form.CategoryUpdateForm;
import cn.leemay.mall.sys.goods.service.CategoryService;
import cn.leemay.mall.sys.goods.view.CategoryView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 商品类目表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/category")
@Api(tags = "分类")
@CrossOrigin
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加分类")
    public BaseResult<String> add(@RequestBody @Validated CategoryAddForm categoryAddForm) {
        categoryService.add(categoryAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除分类", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改分类", notes = "根据主键id修改")
    public BaseResult<String> update(@RequestBody @Validated CategoryUpdateForm categoryUpdateForm) {
        categoryService.update(categoryUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询品牌")
    public BaseResult<CategoryView> get(@PathVariable("id") Long id) {
        CategoryView result = categoryService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询分类")
    public BaseResult<ResultPage<CategoryView>> list(@RequestBody CategoryListForm categoryListForm) {
        ResultPage<CategoryView> result = categoryService.list(categoryListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @GetMapping("/tree")
    @ApiOperation("树形查询所有显示分类")
    public BaseResult<List<CategoryView>> tree() {
        List<CategoryView> result = categoryService.tree();
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}

