package cn.leemay.mall.goods.controller;


import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.goods.entity.Category;
import cn.leemay.mall.goods.service.CategoryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ApiOperation("添加分类")
    public BaseResult<String> insert(@RequestBody Category category) {
        if (category == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        categoryService.insert(category);
        return new BaseResult<>(ResultCode.OK, "添加成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除分类", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        if (id == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        categoryService.delete(id);
        return new BaseResult<>(ResultCode.OK, "删除成功");
    }

    @PutMapping
    @ApiOperation(value = "修改分类", notes = "根据主键id修改")
    public BaseResult<String> update(@RequestBody Category category) {
        if (category == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        categoryService.update(category);
        return new BaseResult<>(ResultCode.OK, "修改成功");
    }

    @PostMapping("/selectPageByCondition/{index}/{size}")
    @ApiOperation("根据条件分页查询分类")
    public BaseResult<Page<Category>> selectPageByCondition(@RequestBody Category category,
                                                            @PathVariable("index") Integer index,
                                                            @PathVariable("size") Integer size) {
        if (category == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        Page<Category> result = categoryService.selectPageByCondition(category, index, size);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectListByCondition")
    @ApiOperation("根据条件查询分类")
    public BaseResult<List<Category>> selectListByCondition(@RequestBody Category category) {
        if (category == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        List<Category> result = categoryService.selectListByCondition(category);
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectWithTree")
    @ApiOperation("树形查询所有显示分类")
    public BaseResult<List<Category>> selectWithTree() {
        List<Category> result = categoryService.selectWithTree();
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }
}

