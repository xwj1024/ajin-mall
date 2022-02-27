package cn.leemay.mall.goods.controller;


import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultEnum;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.view.CategoryDTO;
import cn.leemay.mall.goods.entity.form.CategoryInsertVO;
import cn.leemay.mall.goods.entity.form.CategorySelectVO;
import cn.leemay.mall.goods.entity.form.CategoryUpdateVO;
import cn.leemay.mall.goods.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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
@RequestMapping("/api/goods/category")
@Api(tags = "分类")
@CrossOrigin
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加分类")
    public BaseResult<String> insertCategory(@RequestBody @Validated CategoryInsertVO categoryInsertVO) {
        categoryService.insertCategory(categoryInsertVO);
        return new BaseResult<>(ResultEnum.INSERT_OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除分类", notes = "根据主键id删除")
    public BaseResult<String> deleteCategory(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改分类", notes = "根据主键id修改")
    public BaseResult<String> updateCategory(@RequestBody @Validated CategoryUpdateVO categoryUpdateVO) {
        categoryService.updateCategory(categoryUpdateVO);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询品牌")
    public BaseResult<CategoryDTO> selectOneById(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        CategoryDTO result = categoryService.selectOneById(id);
        if (result == null) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }

    @PostMapping("/selectListByCondition")
    @ApiOperation("根据条件查询分类")
    public BaseResult<List<CategoryDTO>> selectListByCondition(@RequestBody CategorySelectVO categorySelectVO) {
        List<CategoryDTO> result = categoryService.selectListByCondition(categorySelectVO);
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }

    @PostMapping("/selectPageByCondition/{index}/{size}")
    @ApiOperation("根据条件分页查询分类")
    public BaseResult<ResultPage<CategoryDTO>> selectPageByCondition(@RequestBody CategorySelectVO categorySelectVO,
                                                                     @PathVariable("index") Integer index,
                                                                     @PathVariable("size") Integer size) {
        ResultPage<CategoryDTO> result = categoryService.selectPageByCondition(categorySelectVO, index, size);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }

    @GetMapping("/selectWithTree")
    @ApiOperation("树形查询所有显示分类")
    public BaseResult<List<CategoryDTO>> selectWithTree() {
        List<CategoryDTO> result = categoryService.selectWithTree();
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }
}

