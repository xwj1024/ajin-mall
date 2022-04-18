package ajin.mall.sys.auth.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Ajin
 * @since 2022-4-17
 */
@Data
public class LoginForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户名 不能为空")
    @ApiModelProperty("用户名")
    private String username;

    @NotBlank(message = "密码 不能为空")
    @ApiModelProperty("密码")
    private String password;
}
