//package cn.leemay.mall.sys.system.controller;
//
//
//import cn.leemay.mall.common.base.result.BaseResult;
//import cn.leemay.mall.common.base.result.ResultCode;
//import cn.leemay.mall.common.data.entity.system.SysUser;
//import cn.leemay.mall.sys.system.service.SysUserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
///**
// * <p>
// * 管理员表 前端控制器
// * </p>
// *
// * @author Ajin
// * @since 2021-05-07
// */
//@RestController
//@RequestMapping("/system/sysUser")
//@Api(tags = "系统用户")
//@CrossOrigin
//public class SysUserController {
//
//    @Resource
//    private SysUserService sysUserService;
//
//    @PostMapping
//    @ApiOperation("添加系统用户")
//    public BaseResult<String> insert(@RequestBody SysUser sysUser) {
//        if (sysUser == null) {
//            return new BaseResult<>(ResultCode.ERR, "数据错误");
//        }
//        sysUserService.insert(sysUser);
//        return new BaseResult<>(ResultCode.OK, "添加成功");
//    }
//
//}
//
