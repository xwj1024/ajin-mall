package cn.leemay.mall.sys.monitor.controller;

import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultEnum;
import cn.leemay.mall.sys.monitor.entity.ServerInfo;
import cn.leemay.mall.sys.monitor.service.ServerInfoService;
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
@RequestMapping("/monitor/server")
@Api(tags = "服务器信息")
@CrossOrigin
public class ServerInfoController {

    @Autowired
    private ServerInfoService serverInfoService;

    @GetMapping
    @ApiOperation("获取服务器信息")
    public BaseResult<ServerInfo> getHardwareInfo() {
        ServerInfo result = serverInfoService.getServerInfo();
        if (result == null) {
            return new BaseResult<>(ResultEnum.SELECT_INFO);
        }
        return new BaseResult<>(ResultEnum.SELECT_OK, result);
    }
}
