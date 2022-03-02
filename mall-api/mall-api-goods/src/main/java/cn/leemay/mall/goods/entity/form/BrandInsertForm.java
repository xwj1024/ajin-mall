package cn.leemay.mall.goods.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel("品牌添加对象")
public class BrandInsertForm implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "品牌名称不能为空")
    @ApiModelProperty("品牌名称")
    private String name;

    @NotBlank(message = "品牌图片不能为空")
    @ApiModelProperty("品牌图片")
    private String image;

    @NotBlank(message = "品牌首字母不能为空")
    @ApiModelProperty("首字母")
    private String initials;

    @ApiModelProperty("排序")
    private Integer sort;

}
