package ajin.mall.sys.goods.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-20
 */
@Data
@ApiModel("品牌添加对象")
public class BrandAddForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @Size(max = 50, message = "品牌名称不能超过50个字符")
    @NotBlank(message = "品牌名称不能为空")
    @ApiModelProperty("品牌名称")
    private String name;

    @NotBlank(message = "品牌图片不能为空")
    @ApiModelProperty("品牌图片")
    private String image;

    @Size(max = 50, message = "品牌首字母不能超过50个字符")
    @Pattern(regexp = "^[A-Za-z]+$", message = "品牌首字母只能为英文字母")
    @NotBlank(message = "品牌首字母不能为空")
    @ApiModelProperty("首字母")
    private String initial;

    @Max(value = Integer.MAX_VALUE, message = "排序数值过大")
    @Positive(message = "排序必须为正整数")
    @ApiModelProperty("排序")
    private Integer sort;

}
