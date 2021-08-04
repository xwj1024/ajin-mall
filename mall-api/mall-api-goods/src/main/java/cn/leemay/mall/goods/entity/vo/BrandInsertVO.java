package cn.leemay.mall.goods.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel("品牌添加对象")
public class BrandInsertVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "品牌名称不能为空")
    @ApiModelProperty("品牌名称")
    private String name;

    @NotNull(message = "品牌图片不能为空")
    @ApiModelProperty("品牌图片")
    private String image;

    @NotNull(message = "品牌首字母不能为空")
    @ApiModelProperty("首字母")
    private String initials;

    @ApiModelProperty("排序")
    private Integer sort;

}
