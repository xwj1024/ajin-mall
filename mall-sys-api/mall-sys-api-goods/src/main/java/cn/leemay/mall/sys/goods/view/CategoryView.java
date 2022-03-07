package cn.leemay.mall.sys.goods.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author Ajin
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel("分类结果对象")
public class CategoryView implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类id")
    private Long id;

    @ApiModelProperty("上级id")
    private Long parentId;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("分类图片")
    private String image;

    @ApiModelProperty("分类级别")
    private Integer level;

    @ApiModelProperty("分类排序")
    private Integer sort;

    @ApiModelProperty(hidden = true)
    private List<CategoryView> child;
}
