package ajin.mall.sys.monitor.controller;

import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultEnum;
import ajin.mall.sys.monitor.entity.ServerInfo;
import ajin.mall.sys.monitor.service.ServerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ajin
 * @since 2021-8-11
 */
@RestController
@RequestMapping("/server")
@Api(tags = "服务器信息")
@CrossOrigin
public class ServerInfoController {

    @Resource
    private ServerInfoService serverInfoService;

    @GetMapping
    @ApiOperation("获取服务器信息")
    public BaseResult<ServerInfo> getHardwareInfo() {
        ServerInfo result = serverInfoService.getServerInfo();
        return new BaseResult<>(ResultEnum.GET_OK, result);
    }
}
