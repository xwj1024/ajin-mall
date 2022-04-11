package ajin.mall.sys.member.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author Ajin
 */
@ApiModel(value = "会员添加")
@Data
public class MemberAddForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "账号 不能为空")
    @ApiModelProperty(value = "账号", required = true)
    private String username;

    @NotBlank(message = "密码 不能为空")
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @NotBlank(message = "会员昵称 不能为空")
    @ApiModelProperty(value = "会员昵称", required = true)
    private String nickname;

    @Min(value = 0, message = "年龄最低不低于0")
    @Max(value = 200, message = "年龄最高不超过200")
    @ApiModelProperty(value = "会员年龄")
    private Integer age;

    @Pattern(regexp = "^1[0123456789]\\d{9}$", message = "手机号格式不正确")
    @ApiModelProperty(value = "手机号")
    private String phone;

    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @Min(value = 0, message = "会员等级 最低0级")
    @Max(value = 100, message = "会员等级 最高100级")
    @ApiModelProperty(value = "会员等级")
    private Integer level;
}
