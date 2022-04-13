package ajin.mall.sys.member.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 地址添加表单
 *
 * @author Ajin
 * @date 2022/04/13
 */
@Data
public class AddressAddForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "会员id 不能为空")
    @ApiModelProperty(value = "会员id", required = true)
    private Long memberId;

    @Size(max = 20, message = "收件人 名字不能超过20字符")
    @NotBlank(message = "收件人 不能为空")
    @ApiModelProperty(value = "收件人", required = true)
    private String addressee;

    @Pattern(regexp = "^1[0123456789]\\d{9}$", message = "手机号格式不正确")
    @NotBlank(message = "手机号 不能为空")
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;

    @Size(max = 50, message = "省 不能超过50字符")
    @NotBlank(message = "省 不能为空")
    @ApiModelProperty(value = "省", required = true)
    private String province;

    @Size(max = 50, message = "市 不能超过50字符")
    @NotBlank(message = "市 不能为空")
    @ApiModelProperty(value = "市", required = true)
    private String city;

    @Size(max = 50, message = "区县 不能超过50字符")
    @NotBlank(message = "区县 不能为空")
    @ApiModelProperty(value = "区县", required = true)
    private String area;

    @Size(max = 50, message = "乡镇街道 不能超过50字符")
    @NotBlank(message = "乡镇街道 不能为空")
    @ApiModelProperty(value = "乡镇街道", required = true)
    private String town;

    @Size(max = 50, message = "详细地址 不能超过200字符")
    @NotBlank(message = "详细地址 不能为空")
    @ApiModelProperty(value = "详细地址", required = true)
    private String detail;

    @NotNull
    @Max(1)
    @Min(0)
    @ApiModelProperty(value = "是否默认", required = true)
    private Integer isDefault;

}
