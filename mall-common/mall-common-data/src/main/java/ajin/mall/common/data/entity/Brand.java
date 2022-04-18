package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品品牌表
 *
 * @author Ajin
 */
@ApiModel(value = "商品品牌表")
@Data
@TableName(value = "brand")
@EqualsAndHashCode(callSuper = true)
public class Brand extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableField(value = "`name`")
    @ApiModelProperty(value = "品牌名称")
    private String name;

    @TableField(value = "`initial`")
    @ApiModelProperty(value = "首字母")
    private String initial;

    @TableField(value = "image")
    @ApiModelProperty(value = "品牌图片")
    private String image;

    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableField(value = "is_show")
    @ApiModelProperty(value = "是否显示")
    private Integer isShow;

}