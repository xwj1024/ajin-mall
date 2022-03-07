package cn.leemay.mall.tool.controller;

import cn.leemay.mall.common.base.anno.RepeatSubmit;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.tool.service.SmsService;
import com.aliyuncs.exceptions.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Ajin
 * @since 2021-05-06
 */
@RestController
@RequestMapping("/tool/sms")
@Api(tags = "短信服务")
@CrossOrigin
public class SmsController {

    @Resource
    private SmsService smsService;

    @RepeatSubmit
    @GetMapping("/getCheckCode/{phone}")
    @ApiOperation("获取短信验证码")
    public BaseResult<String> getCheckCode(@PathVariable("phone") String phone) throws ClientException {
        smsService.getCheckCode(phone);
        return new BaseResult<>(ResultCode.OK, "获取成功");
    }

}
