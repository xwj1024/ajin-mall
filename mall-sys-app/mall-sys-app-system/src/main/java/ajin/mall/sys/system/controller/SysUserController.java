package ajin.mall.sys.system.controller;


import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultCode;
import ajin.mall.sys.system.form.SysUserAddForm;
import ajin.mall.sys.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
@RestController
@RequestMapping("/sysUser")
@Api(tags = "系统用户")
@CrossOrigin
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping
    @ApiOperation("添加系统用户")
    public BaseResult<String> add(@Validated @RequestBody SysUserAddForm sysUserAddForm) {
        sysUserService.add(sysUserAddForm);
        return new BaseResult<>(ResultCode.OK, "添加成功");
    }

}

