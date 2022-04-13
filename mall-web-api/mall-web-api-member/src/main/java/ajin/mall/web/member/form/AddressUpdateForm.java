package ajin.mall.web.member.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 地址更新表单
 *
 * @author Ajin
 * @date 2022/04/13
 */
@Data
public class AddressUpdateForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "地址id 不能为空")
    @ApiModelProperty(value = "地址id")
    private Long id;

    @Size(max = 20, message = "收件人 名字不能超过20字符")
    @ApiModelProperty(value = "收件人")
    private String addressee;

    @Pattern(regexp = "^1[0123456789]\\d{9}$", message = "手机号格式不正确")
    @ApiModelProperty(value = "手机号")
    private String phone;

    @Size(max = 50, message = "省 不能超过50字符")
    @ApiModelProperty(value = "省")
    private String province;

    @Size(max = 50, message = "市 不能超过50字符")
    @ApiModelProperty(value = "市")
    private String city;

    @Size(max = 50, message = "区县 不能超过50字符")
    @ApiModelProperty(value = "区县")
    private String area;

    @Size(max = 50, message = "乡镇街道 不能超过50字符")
    @ApiModelProperty(value = "乡镇街道")
    private String town;

    @Size(max = 50, message = "详细地址 不能超过200字符")
    @ApiModelProperty(value = "详细地址")
    private String detail;

    @Max(1)
    @Min(0)
    @ApiModelProperty(value = "是否默认")
    private Integer isDefault;

}
