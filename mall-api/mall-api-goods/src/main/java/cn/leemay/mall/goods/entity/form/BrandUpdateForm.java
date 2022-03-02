package cn.leemay.mall.goods.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel("品牌修改对象")
public class BrandUpdateForm implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "品牌id不能为空")
    @ApiModelProperty("品牌id")
    private Long id;

    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("品牌图片")
    private String image;

    @ApiModelProperty("首字母")
    private String initials;

    @ApiModelProperty("排序")
    private Integer sort;

}
