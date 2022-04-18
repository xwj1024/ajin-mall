package ajin.mall.sys.auth.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 改变形式
 *
 * @author Ajin
 * @date 2022-4-17
 */

@Data
public class ChangeForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户名 不能为空")
    @ApiModelProperty("用户名")
    private String username;

    @NotBlank(message = "旧密码 不能为空")
    @ApiModelProperty("旧密码")
    private String oldPassword;

    @NotBlank(message = "新密码 不能为空")
    @ApiModelProperty("新密码")
    private String newPassword;
}
