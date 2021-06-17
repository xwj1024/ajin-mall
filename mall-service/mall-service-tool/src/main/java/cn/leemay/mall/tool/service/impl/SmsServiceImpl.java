package cn.leemay.mall.tool.service.impl;

import cn.leemay.mall.common.base.constant.RedisConstants;
import cn.leemay.mall.common.base.exception.BusException;
import cn.leemay.mall.tool.property.SmsProperties;
import cn.leemay.mall.tool.service.SmsService;
import cn.leemay.mall.tool.util.CodeUtils;
import cn.leemay.mall.tool.util.SmsUtils;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void getCheckCode(String phone) throws ClientException {
        String redisCode = stringRedisTemplate.opsForValue().get(RedisConstants.CHECK_CODE + phone);
        if (redisCode != null) {
            long time = Long.parseLong(redisCode.split(",")[1]);
            if (System.currentTimeMillis() - time < 60000) {
                throw new BusException("验证码请求频繁，请一分钟后重试");
            }
        }
        String code = CodeUtils.generateCode4Int(4).toString();
        redisCode = code + "," + System.currentTimeMillis();
        stringRedisTemplate.opsForValue()
                .set(RedisConstants.CHECK_CODE + phone, redisCode, smsProperties.getExpire(), TimeUnit.SECONDS);
        SmsUtils.sendCheckCode(smsProperties.getKey(), smsProperties.getSecret(), smsProperties.getSign(), smsProperties.getTemplate(), phone, code);
    }
}
