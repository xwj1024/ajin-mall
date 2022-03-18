package cn.leemay.mall.sys.goods.controller;


import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultEnum;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.LabelGoodsAddForm;
import cn.leemay.mall.sys.goods.form.LabelGoodsListForm;
import cn.leemay.mall.sys.goods.form.LabelGoodsUpdateForm;
import cn.leemay.mall.sys.goods.service.LabelGoodsService;
import cn.leemay.mall.sys.goods.view.LabelGoodsView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 标签,商品 关联表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/labelGoods")
@CrossOrigin
@Api(tags = "标签，商品")
public class LabelGoodsController {
    
    @Resource
    private LabelGoodsService labelGoodsService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加标签，商品")
    public BaseResult<String> add(@Validated @RequestBody LabelGoodsAddForm labelGoodsAddForm) {
        labelGoodsService.add(labelGoodsAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除标签，商品", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        labelGoodsService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改标签，商品", notes = "根据主键id修改")
    public BaseResult<String> update(@Validated @RequestBody LabelGoodsUpdateForm labelGoodsUpdateForm) {
        labelGoodsService.update(labelGoodsUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询标签，商品")
    public BaseResult<LabelGoodsView> get(@PathVariable("id") Long id) {
        LabelGoodsView result = labelGoodsService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询标签，商品")
    public BaseResult<ResultPage<LabelGoodsView>> list(@RequestBody LabelGoodsListForm labelGoodsListForm) {
        ResultPage<LabelGoodsView> result = labelGoodsService.list(labelGoodsListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}

