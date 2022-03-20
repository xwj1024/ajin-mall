package ajin.mall.sys.system.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Ajin
 */
@Data
public class SysUserAddForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "账号不能为空")
    @ApiModelProperty(value = "账号")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码最低6位，最高20位")
    @ApiModelProperty(value = "密码")
    private String password;

    @NotBlank(message = "昵称不能为空")
    @ApiModelProperty(value = "昵称")
    private String nickname;
}
