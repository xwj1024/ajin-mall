package ajin.mall.sys.goods.controller;


import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.LabelAddForm;
import ajin.mall.sys.goods.form.LabelListForm;
import ajin.mall.sys.goods.form.LabelUpdateForm;
import ajin.mall.sys.goods.service.LabelService;
import ajin.mall.sys.goods.view.LabelView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品标签表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
@Api(tags = "商品标签")
public class LabelController {

    @Resource
    private LabelService labelService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加商品标签")
    public BaseResult<String> add(@RequestBody @Validated LabelAddForm labelAddForm) {
        labelService.add(labelAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除商品标签", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        labelService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改商品标签", notes = "根据主键id修改")
    public BaseResult<String> update(@RequestBody @Validated LabelUpdateForm labelUpdateForm) {
        labelService.update(labelUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询商品标签")
    public BaseResult<LabelView> get(@PathVariable("id") Long id) {
        LabelView result = labelService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询商品标签")
    public BaseResult<ResultPage<LabelView>> list(@RequestBody LabelListForm labelListForm) {
        ResultPage<LabelView> result = labelService.list(labelListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}

