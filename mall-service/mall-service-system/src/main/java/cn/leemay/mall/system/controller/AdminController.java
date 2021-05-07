package cn.leemay.mall.system.controller;


import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.system.entity.Admin;
import cn.leemay.mall.system.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
@RestController
@RequestMapping("/system/admin")
@Api(tags = "管理员")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    @ApiOperation("添加管理员")
    public BaseResult<String> insert(@RequestBody Admin admin) {
        if (admin == null) {
            return new BaseResult<>(ResultCode.ERR, "数据错误");
        }
        adminService.insert(admin);
        return new BaseResult<>(ResultCode.OK, "添加成功");
    }

}

