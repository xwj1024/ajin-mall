package cn.leemay.mall.goods.controller;


import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.Sku;
import cn.leemay.mall.goods.service.SkuService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/goods/sku")
@Api(tags = "商品sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @PostMapping
    @ApiOperation("添加sku")
    public BaseResult<String> insert(@RequestBody Sku sku) {
        if (sku == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        skuService.insert(sku);
        return new BaseResult<>(ResultCode.OK, "添加成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除sku")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        if (id == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        skuService.delete(id);
        return new BaseResult<>(ResultCode.OK, "删除成功");
    }

    @PutMapping
    @ApiOperation("修改sku")
    public BaseResult<String> update(@RequestBody Sku sku) {
        if (sku == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        skuService.update(sku);
        return new BaseResult<>(ResultCode.OK, "修改成功");
    }

    @PostMapping("/selectPageByCondition/{index}/{size}")
    @ApiOperation("根据条件分页查询Sku")
    public BaseResult<Page<Sku>> selectPageByCondition(@RequestBody Sku sku,
                                                       @PathVariable("index") Integer index,
                                                       @PathVariable("size") Integer size) {
        if (sku == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        Page<Sku> result = skuService.selectPageByCondition(sku, index, size);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectListByCondition")
    @ApiOperation("根据条件查询Sku")
    public BaseResult<List<Sku>> selectListByCondition(@RequestBody Sku sku) {
        if (sku == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        List<Sku> result = skuService.selectListByCondition(sku);
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }
}

