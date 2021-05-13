package cn.leemay.mall.goods.controller;


import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.goods.entity.Brand;
import cn.leemay.mall.goods.service.BrandService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/goods/brand")
@Api(tags = "品牌")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    @ApiOperation("添加品牌")
    public BaseResult<String> insert(@RequestBody Brand brand) {
        if (brand == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        brandService.insert(brand);
        return new BaseResult<>(ResultCode.OK, "添加成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除品牌", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        if (id == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        brandService.delete(id);
        return new BaseResult<>(ResultCode.OK, "删除成功");
    }

    @PutMapping
    @ApiOperation(value = "修改品牌", notes = "根据主键id修改")
    public BaseResult<String> update(@RequestBody Brand brand) {
        if (brand == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        brandService.update(brand);
        return new BaseResult<>(ResultCode.OK, "修改成功");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询品牌")
    public BaseResult<Brand> selectOneById(@PathVariable("id") Long id) {
        if (id == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        Brand result = brandService.selectOneById(id);
        if (result == null) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectListByCondition")
    @ApiOperation("根据条件查询品牌")
    public BaseResult<List<Brand>> selectListByCondition(@RequestBody Brand brand) {
        if (brand == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        List<Brand> result = brandService.selectListByCondition(brand);
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectPageByCondition/{index}/{size}")
    @ApiOperation("根据条件分页查询品牌")
    public BaseResult<Page<Brand>> selectPageByCondition(@RequestBody Brand brand,
                                                         @PathVariable("index") Integer index,
                                                         @PathVariable("size") Integer size) {
        if (brand == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        Page<Brand> result = brandService.selectPageByCondition(brand, index, size);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }
}

