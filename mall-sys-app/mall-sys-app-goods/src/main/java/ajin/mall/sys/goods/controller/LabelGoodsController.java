package ajin.mall.sys.goods.controller;


import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.LabelGoodsAddForm;
import ajin.mall.sys.goods.form.LabelGoodsListForm;
import ajin.mall.sys.goods.form.LabelGoodsUpdateForm;
import ajin.mall.sys.goods.service.LabelGoodsService;
import ajin.mall.sys.goods.view.LabelGoodsView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品标签,商品 关联表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/labelGoods")
@CrossOrigin
@Api(tags = "商品标签，商品")
public class LabelGoodsController {
    
    @Resource
    private LabelGoodsService labelGoodsService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加商品标签，商品")
    public BaseResult<String> add(@Validated @RequestBody LabelGoodsAddForm labelGoodsAddForm) {
        labelGoodsService.add(labelGoodsAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除商品标签，商品", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        labelGoodsService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改商品标签，商品", notes = "根据主键id修改")
    public BaseResult<String> update(@Validated @RequestBody LabelGoodsUpdateForm labelGoodsUpdateForm) {
        labelGoodsService.update(labelGoodsUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询商品标签，商品")
    public BaseResult<LabelGoodsView> get(@PathVariable("id") Long id) {
        LabelGoodsView result = labelGoodsService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询商品标签，商品")
    public BaseResult<ResultPage<LabelGoodsView>> list(@RequestBody LabelGoodsListForm labelGoodsListForm) {
        ResultPage<LabelGoodsView> result = labelGoodsService.list(labelGoodsListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}

