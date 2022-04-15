package ajin.mall.web.member.controller;

import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.web.member.form.MemberUpdateForm;
import ajin.mall.web.member.service.MemberService;
import ajin.mall.web.member.view.MemberView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 成员控制器
 *
 * @author Ajin
 * @date 2022/04/13
 */
@RestController
@RequestMapping("/member")
@Api(tags = "会员")
@CrossOrigin
public class MemberController {

    @Resource
    private MemberService memberService;

    @RepeatSubmit
    @PutMapping
    @ApiOperation("修改会员")
    public BaseResult<String> update(@Validated @RequestBody MemberUpdateForm memberUpdateForm) {
        memberService.update(memberUpdateForm);
        return new BaseResult<>(ResultEnum.UPDATE_OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询会员")
    public BaseResult<MemberView> get(@PathVariable("id") Long id) {
        MemberView result = memberService.get(id);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}
