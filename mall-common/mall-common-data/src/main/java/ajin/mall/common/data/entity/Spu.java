package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品spu表
 *
 * @author Ajin
 */
@ApiModel(value = "商品spu表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "spu")
public class Spu extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "spu名称")
    private String name;

    @TableField(value = "caption")
    @ApiModelProperty(value = "商品标题")
    private String caption;

    @TableField(value = "details")
    @ApiModelProperty(value = "商品详情")
    private String details;

    @TableField(value = "brand_id")
    @ApiModelProperty(value = "品牌id")
    private Long brandId;

    @TableField(value = "category1_id")
    @ApiModelProperty(value = "一级分类")
    private Long category1Id;

    @TableField(value = "category2_id")
    @ApiModelProperty(value = "二级分类")
    private Long category2Id;

    @TableField(value = "category3_id")
    @ApiModelProperty(value = "三级分类")
    private Long category3Id;


}