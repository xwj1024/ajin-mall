package cn.leemay.mall.tool.service.impl;

import cn.leemay.mall.common.base.constant.RedisConstants;
import cn.leemay.mall.tool.property.SmsProperties;
import cn.leemay.mall.tool.service.SmsService;
import cn.leemay.mall.tool.util.CodeUtils;
import cn.leemay.mall.tool.util.SmsUtils;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Ajin
 * @since 2021-05-06
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsProperties smsProperties;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void getCheckCode(String phone) throws ClientException {
        Integer code = CodeUtils.generateCode4Int(4);
        BoundValueOperations valueOperations = redisTemplate.boundValueOps(RedisConstants.CHECK_CODE + phone);
        valueOperations.set(code, smsProperties.getExpire(), TimeUnit.SECONDS);
        SmsUtils.sendCheckCode(smsProperties.getKey(), smsProperties.getSecret(),
                smsProperties.getSign(), smsProperties.getTemplate(), phone, code.toString());
    }
}
