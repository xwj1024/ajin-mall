package ajin.mall.sys.goods.controller;


import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.EvaluationAddForm;
import ajin.mall.sys.goods.form.EvaluationListForm;
import ajin.mall.sys.goods.form.EvaluationUpdateForm;
import ajin.mall.sys.goods.service.EvaluationService;
import ajin.mall.sys.goods.view.EvaluationView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品评价表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/evaluation")
@CrossOrigin
@Api(tags = "商品评价")
public class EvaluationController {

    @Resource
    private EvaluationService evaluationService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加商品评价")
    public BaseResult<String> add(@RequestBody @Validated EvaluationAddForm evaluationAddForm) {
        evaluationService.add(evaluationAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除商品评价", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        evaluationService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改商品评价", notes = "根据主键id修改")
    public BaseResult<String> update(@RequestBody @Validated EvaluationUpdateForm evaluationUpdateForm) {
        evaluationService.update(evaluationUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询商品评价")
    public BaseResult<EvaluationView> get(@PathVariable("id") Long id) {
        EvaluationView result = evaluationService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询商品评价")
    public BaseResult<ResultPage<EvaluationView>> list(@RequestBody EvaluationListForm evaluationListForm) {
        ResultPage<EvaluationView> result = evaluationService.list(evaluationListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}

