package ajin.mall.web.member.controller;

import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.web.member.form.FavoriteOnOrOffForm;
import ajin.mall.web.member.form.FavoriteListForm;
import ajin.mall.web.member.service.FavoriteService;
import ajin.mall.web.member.view.FavoriteView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 收藏控制器
 *
 * @author Ajin
 * @date 2022/04/13
 */
@RestController
@RequestMapping("/favorite")
@Api(tags = "收藏")
@CrossOrigin
public class FavoriteController {

    @Resource
    private FavoriteService favoriteService;

    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加或取消收藏")
    public BaseResult<Boolean> onOrOff(@Validated @RequestBody FavoriteOnOrOffForm favoriteOnOrOffForm) {
        // todo 关于会员的都要进行验证是否是该会员本身操作
        Boolean result = favoriteService.onOrOff(favoriteOnOrOffForm);
        return new BaseResult<>(ResultEnum.OPERATE_OK, result);
    }

    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation("删除收藏")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        favoriteService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @PostMapping("/list")
    @ApiOperation("根据条件查询收藏")
    public BaseResult<ResultPage<FavoriteView>> list(@RequestBody FavoriteListForm favoriteListForm) {
        ResultPage<FavoriteView> result = favoriteService.list(favoriteListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}
