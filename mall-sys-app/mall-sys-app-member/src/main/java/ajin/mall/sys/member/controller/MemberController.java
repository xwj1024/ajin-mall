package ajin.mall.sys.member.controller;

import ajin.mall.common.base.anno.RepeatSubmit;
import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.common.data.enums.TableInfo;
import ajin.mall.sys.common.anno.RecordSysLog;
import ajin.mall.sys.member.form.MemberAddForm;
import ajin.mall.sys.member.form.MemberListForm;
import ajin.mall.sys.member.form.MemberUpdateForm;
import ajin.mall.sys.member.service.MemberService;
import ajin.mall.sys.member.view.MemberView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Ajin
 */
@RestController
@RequestMapping("/member")
@Api(tags = "会员")
@CrossOrigin
public class MemberController {

    @Resource
    private MemberService memberService;

    @RecordSysLog("添加会员")
    @RepeatSubmit
    @PostMapping
    @ApiOperation("添加会员")
    public BaseResult<String> add(@Validated @RequestBody MemberAddForm memberAddForm) {
        memberService.add(memberAddForm);
        return new BaseResult<>(ResultEnum.ADD_OK);
    }

    @RecordSysLog("删除会员")
    @RepeatSubmit
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除会员", notes = "根据主键id删除")
    public BaseResult<String> delete(@PathVariable("id") Long id) {
        memberService.delete(id);
        return new BaseResult<>(ResultEnum.DELETE_OK);
    }

    @RecordSysLog(value = "修改会员", saveSourceData = TableInfo.BRAND)
    @RepeatSubmit
    @PutMapping
    @ApiOperation(value = "修改会员", notes = "根据主键id修改")
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

    @PostMapping("/list")
    @ApiOperation("根据条件查询会员")
    public BaseResult<ResultPage<MemberView>> list(@RequestBody MemberListForm memberListForm) {
        ResultPage<MemberView> result = memberService.list(memberListForm);
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}
