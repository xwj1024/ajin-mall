package cn.leemay.mall.goods.controller;


import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.goods.entity.Spu;
import cn.leemay.mall.goods.entity.vo.SpuSelectVO;
import cn.leemay.mall.goods.service.SpuService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品spu表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/goods/spu")
@CrossOrigin
@Api(tags = "商品spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @PostMapping
    @ApiOperation("添加spu")
    public BaseResult<String> insertSpu(@RequestBody Spu spu) {
        if (spu == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        spuService.insertSpu(spu);
        return new BaseResult<>(ResultCode.OK, "添加成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除spu")
    public BaseResult<String> deleteSpu(@PathVariable("id") Long id) {
        if (id == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        spuService.deleteSpu(id);
        return new BaseResult<>(ResultCode.OK, "删除成功");
    }

    @PutMapping
    @ApiOperation("修改spu")
    public BaseResult<String> updateSpu(@RequestBody Spu spu) {
        if (spu == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        spuService.updateSpu(spu);
        return new BaseResult<>(ResultCode.OK, "修改成功");
    }
    @GetMapping("/{id}")
    @ApiOperation("根据id查询spu")
    public BaseResult<Spu> selectOneById(@PathVariable("id") Long id) {
        if (id == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        Spu result = spuService.selectOneById(id);
        if (result == null) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }
    @PostMapping("/selectListByCondition")
    @ApiOperation("根据条件查询Spu")
    public BaseResult<List<Spu>> selectListByCondition(@RequestBody SpuSelectVO spuSelectVO) {
        if (spuSelectVO == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        List<Spu> result = spuService.selectListByCondition(spuSelectVO);
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }

    @PostMapping("/selectPageByCondition/{index}/{size}")
    @ApiOperation("根据条件分页查询Spu")
    public BaseResult<Page<Spu>> selectPageByCondition(@RequestBody SpuSelectVO spuSelectVO,
                                                       @PathVariable("index") Integer index,
                                                       @PathVariable("size") Integer size) {
        if (spuSelectVO == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        Page<Spu> result = spuService.selectPageByCondition(spuSelectVO, index, size);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultCode.ERR, "暂无数据");
        }
        return new BaseResult<>(ResultCode.OK, "查询成功", result);
    }
}

