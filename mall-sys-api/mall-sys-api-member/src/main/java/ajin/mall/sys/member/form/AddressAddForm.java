package ajin.mall.sys.member.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author Ajin
 */
@Data
public class AddressAddForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "会员id 不能为空")
    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @Size(max = 50,message = "省 不能超过50字符")
    @NotBlank(message = "省 不能为空")
    @ApiModelProperty(value = "省")
    private String province;

    @Size(max = 50,message = "市 不能超过50字符")
    @NotBlank(message = "市 不能为空")
    @ApiModelProperty(value = "市")
    private String city;

    @Size(max = 50,message = "区县 不能超过50字符")
    @NotBlank(message = "区县 不能为空")
    @ApiModelProperty(value = "区县")
    private String area;

    @Size(max = 50,message = "乡镇街道 不能超过50字符")
    @NotBlank(message = "乡镇街道 不能为空")
    @ApiModelProperty(value = "乡镇街道")
    private String town;

    @Size(max = 50,message = "详细地址 不能超过200字符")
    @NotBlank(message = "详细地址 不能为空")
    @ApiModelProperty(value = "详细地址")
    private String detail;

    @NotNull
    @Max(1)
    @Min(0)
    @ApiModelProperty(value = "是否默认", required = true)
    private Integer isDefault;

}
