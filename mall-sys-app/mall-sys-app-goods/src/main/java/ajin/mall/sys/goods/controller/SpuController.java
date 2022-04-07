package ajin.mall.sys.goods.controller;


import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.SpuAddForm;
import ajin.mall.sys.goods.form.SpuListForm;
import ajin.mall.sys.goods.form.SpuUpdateForm;
import ajin.mall.sys.goods.service.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
public class SpuController {

    @Resource
    private SpuService spuService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加spu")
    public BaseResult<String> add(@Validated @RequestBody SpuAddForm spuAddForm) {
        spuService.add(spuAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除spu")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        spuService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation("修改spu")
    public BaseResult<String> update(@Validated @RequestBody SpuUpdateForm spuUpdateForm) {
        spuService.update(spuUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询spu")
    public BaseResult<Spu> get(@PathVariable("id") Long id) {
        Spu result = spuService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件分页查询Spu")
    public BaseResult<ResultPage<Spu>> list(@RequestBody SpuListForm spuListForm) {
        ResultPage<Spu> result = spuService.list(spuListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}

