package cn.leemay.mall.sys.goods.controller;


import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultEnum;
import cn.leemay.mall.common.data.entity.goods.Sku;
import cn.leemay.mall.sys.goods.service.SkuService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 商品sku表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/api/goods/sku")
@Api(tags = "商品sku")
@CrossOrigin
public class SkuController {

    @Autowired
    private SkuService skuService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加sku")
    public BaseResult<String> insert(@Validated @RequestBody Sku sku) {
        skuService.insert(sku);
        return new BaseResult<>(ResultEnum.INSERT_OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除sku")
    public BaseResult<String> delete(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        skuService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation("修改sku")
    public BaseResult<String> update(@Validated @RequestBody Sku sku) {
        skuService.update(sku);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询sku")
    public BaseResult<Sku> selectOneById(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        Sku result = skuService.selectOneById(id);
        if (result == null) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }

    @PostMapping("/selectListByCondition")
    @ApiOperation("根据条件查询Sku")
    public BaseResult<List<Sku>> selectListByCondition(@RequestBody Sku sku) {
        List<Sku> result = skuService.selectListByCondition(sku);
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }

    @PostMapping("/selectPageByCondition/{index}/{size}")
    @ApiOperation("根据条件分页查询Sku")
    public BaseResult<Page<Sku>> selectPageByCondition(@RequestBody Sku sku,
                                                       @PathVariable("index") Integer index,
                                                       @PathVariable("size") Integer size) {
        Page<Sku> result = skuService.selectPageByCondition(sku, index, size);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }
}

