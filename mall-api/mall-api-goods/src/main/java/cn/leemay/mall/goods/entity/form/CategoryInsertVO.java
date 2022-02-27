package cn.leemay.mall.goods.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel("分类添加对象")
public class CategoryInsertVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "上级id不能为空")
    @ApiModelProperty("上级id")
    private Long parentId;

    @NotNull(message = "分类名称不能为空")
    @ApiModelProperty("分类名称")
    private String name;

    @NotNull(message = "分类图片不能为空")
    @ApiModelProperty("分类图片")
    private String image;

    @NotNull(message = "分类级别不能为空")
    @ApiModelProperty("分类级别")
    private Integer level;

    @NotNull(message = "分类排序不能为空")
    @ApiModelProperty("分类排序")
    private Integer sort;

    @NotNull(message = "是否显示不能为空")
    @ApiModelProperty("是否显示")
    private Integer isShow;

}
