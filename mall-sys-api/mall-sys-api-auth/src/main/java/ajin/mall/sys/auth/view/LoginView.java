package ajin.mall.sys.auth.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Ajin
 * @date 2022-4-17
 */
@Data
public class LoginView implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("accessToken")
    private String accessToken;

    @ApiModelProperty("refreshToken")
    private String refreshToken;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("上次登录时间")
    private LocalDateTime loginTime;
}
