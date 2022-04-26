package ajin.mall.sys.common.context;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 安全上下文
 *
 * @author Ajin
 * @date 2022/04/26
 */
@Data
public class SecurityContext implements Serializable {
    private static final long serialVersionUID = 123123123L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 角色
     */
    private List<String> roles;

    /**
     * 权限
     */
    private List<String> permissions;

    /**
     * 远程ip
     */
    private String remoteIp;

    /**
     * 请求uri
     */
    private String requestUri;

    /**
     * 请求方法
     */
    private String requestMethod;

}
