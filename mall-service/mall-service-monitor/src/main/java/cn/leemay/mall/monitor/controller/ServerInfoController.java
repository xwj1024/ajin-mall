package cn.leemay.mall.monitor.controller;

import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.monitor.service.ServerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ajin
 * @since 2021-8-11
 */
@RestController
@RequestMapping("/api/monitor/server")
@Api(tags = "服务器信息")
@CrossOrigin
public class ServerInfoController {

    @Autowired
    private ServerInfoService serverInfoService;

    @GetMapping("/hardwareInfo")
    @ApiOperation("获取服务器硬件信息")
    public BaseResult<String> getHardwareInfo() throws Exception {
        serverInfoService.getHardwareInfo();
        return new BaseResult<>();
    }

    @GetMapping("/systemInfo")
    @ApiOperation("获取操作系统信息")
    public BaseResult<String> getSystemInfo() throws Exception {
        serverInfoService.getSystemInfo();
        return new BaseResult<>();
    }
}
