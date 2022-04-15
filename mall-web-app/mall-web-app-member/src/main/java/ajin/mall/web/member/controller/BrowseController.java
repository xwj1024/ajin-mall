package ajin.mall.web.member.controller;

import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.web.member.form.BrowseListForm;
import ajin.mall.web.member.service.BrowseService;
import ajin.mall.web.member.view.BrowseView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 浏览控制器
 *
 * @author Ajin
 * @date 2022/04/15
 */
@RestController
@RequestMapping("/browse")
@Api(tags = "浏览记录")
@CrossOrigin
public class BrowseController {

    @Resource
    private BrowseService browseService;

    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation("删除浏览记录")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        browseService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询浏览记录")
    public BaseResult<ResultPage<BrowseView>> list(@RequestBody BrowseListForm browseListForm) {
        ResultPage<BrowseView> result = browseService.list(browseListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}
