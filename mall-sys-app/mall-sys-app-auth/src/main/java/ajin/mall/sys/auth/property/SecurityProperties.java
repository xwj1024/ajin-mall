package ajin.mall.sys.auth.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 安全属性
 *
 * @author Ajin
 * @date 2022/04/15
 */
@Component
@ConfigurationProperties(prefix = "security")
@Data
public class SecurityProperties implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 登录失败次数限制
     */
    private Integer loginFailTimeLimit = 10;

    /**
     * 登录失败时间限制（分钟）
     */
    private Integer loginFailAfterTime = 10;


    /**
     * 修改密码失败次数限制
     */
    private Integer changeFailTimeLimit = 10;

    /**
     * 修改密码失败时间限制（分钟）
     */
    private Integer changeFailAfterTime = 10;
}
