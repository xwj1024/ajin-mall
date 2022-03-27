package ajin.mall.sys.tool.service.impl;

import ajin.mall.common.base.asserts.BizAssert;
import ajin.mall.common.base.constant.RedisConstants;
import ajin.mall.sys.tool.service.SmsService;
import ajin.mall.sys.tool.property.SmsProperties;
import ajin.mall.sys.tool.util.CodeUtils;
import ajin.mall.sys.tool.util.SmsUtils;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Ajin
 * @since 2021-05-06
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Resource
    private SmsProperties smsProperties;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void getCheckCode(String phone) throws ClientException {
        String redisCode = stringRedisTemplate.opsForValue().get(RedisConstants.CHECK_CODE_PHONE + phone);
        // 判断redis中是否有验证码
        if (redisCode != null) {
            // 如果有验证码，判断验证码请求是否超过1分钟
            long time = Long.parseLong(redisCode.split(",")[1]);
            BizAssert.notTrue(System.currentTimeMillis() - time < 60000, "验证码请求频繁，请一分钟后重试");
        }
        String code = CodeUtils.generateCode4Int(4).toString();
        redisCode = code + "," + System.currentTimeMillis();
        stringRedisTemplate.opsForValue()
                .set(RedisConstants.CHECK_CODE_PHONE + phone, redisCode, smsProperties.getExpire(), TimeUnit.SECONDS);
        SmsUtils.sendCheckCode(smsProperties.getKey(), smsProperties.getSecret(), smsProperties.getSign(), smsProperties.getTemplate(), phone, code);
    }
}
