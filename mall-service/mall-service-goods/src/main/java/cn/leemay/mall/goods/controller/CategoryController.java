package cn.leemay.mall.goods.controller;


import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.common.base.util.ValidateUtils;
import cn.leemay.mall.goods.entity.Category;
import cn.leemay.mall.goods.entity.dto.CategoryDTO;
import cn.leemay.mall.goods.entity.vo.CategoryInsertVO;
import cn.leemay.mall.goods.entity.vo.CategorySelectVO;
import cn.leemay.mall.goods.entity.vo.CategoryUpdateVO;
import cn.leemay.mall.goods.service.CategoryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/goods/category")
@Api(tags = "分类")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ApiOperation("添加分类")
    public BaseResult<String> insertCategory(@RequestBody @Validated CategoryInsertVO categoryInsertVO, BindingResult bindingResult) {
        ValidateUtils.validate(bindingResult);
        categoryService.insertCategory(categoryInsertVO);
        return new BaseResult<>(ResultCode.OK, "添加成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除分类", notes = "根据主键id删除")
    public BaseResult<String> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return new BaseResult<>(ResultCode.OK, "删除成功");
    }

    @PutMapping
    @ApiOperation(value = "修改分类", notes = "根据主键id修改")
    public BaseResult<String> updateCategory(@RequestBody CategoryUpdateVO categoryUpdateVO) {
        categoryService.updateCategory(categoryUpdateVO);
        return new BaseResult<>(ResultCode.OK, "修改成功");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询品牌")
    public BaseResult<CategoryDTO> selectOneById(@PathVariable("id") Long id) {
        CategoryDTO result = categoryService.selectOneById(id);
        if (result == null) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectListByCondition")
    @ApiOperation("根据条件查询分类")
    public BaseResult<List<CategoryDTO>> selectListByCondition(@RequestBody CategorySelectVO categorySelectVO) {
        List<CategoryDTO> result = categoryService.selectListByCondition(categorySelectVO);
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectPageByCondition/{index}/{size}")
    @ApiOperation("根据条件分页查询分类")
    public BaseResult<ResultPage<CategoryDTO>> selectPageByCondition(@RequestBody CategorySelectVO categorySelectVO,
                                                                     @PathVariable("index") Integer index,
                                                                     @PathVariable("size") Integer size) {
        ResultPage<CategoryDTO> result = categoryService.selectPageByCondition(categorySelectVO, index, size);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectWithTree")
    @ApiOperation("树形查询所有显示分类")
    public BaseResult<List<CategoryDTO>> selectWithTree() {
        List<CategoryDTO> result = categoryService.selectWithTree();
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }
}

