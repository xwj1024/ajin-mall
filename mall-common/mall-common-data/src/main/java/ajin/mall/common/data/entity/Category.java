package ajin.mall.common.data.entity;

import ajin.mall.common.data.anno.CascadeField;
import ajin.mall.common.data.enums.TableInfo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品类目表
 *
 * @author Ajin
 */
@ApiModel(value = "商品类目表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "category")
public class Category extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @CascadeField(sourceTable = TableInfo.CATEGORY, linkedTable = TableInfo.CATEGORY, linkedField = "parent_id")
    @TableField(value = "parent_id")
    @ApiModelProperty(value = "上级id")
    private Long parentId;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "分类名称")
    private String name;

    @TableField(value = "image")
    @ApiModelProperty(value = "分类图片")
    private String image;

    @TableField(value = "`level`")
    @ApiModelProperty(value = "分类级别")
    private Integer level;

    @TableField(value = "sort")
    @ApiModelProperty(value = "分类排序")
    private Integer sort;

    @TableField(value = "is_show")
    @ApiModelProperty(value = "是否显示")
    private Integer isShow;

}