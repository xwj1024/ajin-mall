package ajin.mall.sys.tool.service;


import com.aliyuncs.exceptions.ClientException;

/**
 * @author Ajin
 * @since 2021-05-06
 */
public interface SmsService {
    /**
     * 获取短信验证码
     *
     * @param phone 手机号
     * @throws ClientException 异常
     */
    void getCheckCode(String phone) throws ClientException;
}
