package ajin.mall.sys.auth.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

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
}
