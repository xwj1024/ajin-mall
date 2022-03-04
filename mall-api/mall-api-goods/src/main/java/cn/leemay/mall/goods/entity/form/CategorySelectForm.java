package cn.leemay.mall.goods.entity.form;

import cn.leemay.mall.common.base.page.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel("分类查询对象")
public class CategorySelectForm extends PageForm implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("上级id")
    private Long parentId;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("分类级别")
    private Integer level;

    @ApiModelProperty("是否显示")
    private Integer isShow;

}
