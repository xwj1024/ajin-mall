package cn.leemay.mall.sys.goods.controller;


import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultEnum;
import cn.leemay.mall.common.data.entity.goods.Spu;
import cn.leemay.mall.sys.goods.form.SpuAddForm;
import cn.leemay.mall.sys.goods.form.SpuListForm;
import cn.leemay.mall.sys.goods.service.SpuService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RequestMapping("/spu")
@CrossOrigin
@Api(tags = "商品spu")
@Validated
public class SpuController {

    @Resource
    private SpuService spuService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加spu")
    public BaseResult<String> insertSpu(@RequestBody @Validated SpuAddForm spuAddForm) {
        spuService.insertSpu(spuAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除spu")
    public BaseResult<String> deleteSpu(@PathVariable("id") Long id) {
        spuService.deleteSpu(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation("修改spu")
    public BaseResult<String> updateSpu(@Validated @RequestBody Spu spu) {
        spuService.updateSpu(spu);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询spu")
    public BaseResult<Spu> selectOneById(@PathVariable("id") Long id) {
        Spu result = spuService.selectOneById(id);
        if (result == null) {
            return new BaseResult<>(ResultEnum.GET_INFO);
        }
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/selectListByCondition")
    @ApiOperation("根据条件查询Spu")
    public BaseResult<List<Spu>> selectListByCondition(@RequestBody SpuListForm spuListForm) {
        List<Spu> result = spuService.selectListByCondition(spuListForm);
        if (result == null || result.size() <= 0) {
            return new BaseResult<>(ResultEnum.GET_INFO);
        }
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/selectPageByCondition/{index}/{size}")
    @ApiOperation("根据条件分页查询Spu")
    public BaseResult<Page<Spu>> selectPageByCondition(@RequestBody SpuListForm spuListForm,
                                                       @PathVariable("index") Integer index,
                                                       @PathVariable("size") Integer size) {
        Page<Spu> result = spuService.selectPageByCondition(spuListForm, index, size);
        if (result == null || result.getTotal() <= 0) {
            return new BaseResult<>(ResultEnum.GET_INFO);
        }
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}

