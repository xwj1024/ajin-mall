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
 * 商品评价表
 *
 * @author Ajin
 */
@ApiModel(value = "商品评价表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "evaluation")
public class Evaluation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @CascadeField(sourceTable = TableInfo.MEMBER, linkedTable = TableInfo.EVALUATION, linkedField = "member_id")
    @TableField(value = "member_id")
    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @CascadeField(sourceTable = TableInfo.SKU, linkedTable = TableInfo.EVALUATION, linkedField = "sku_id")
    @TableField(value = "sku_id")
    @ApiModelProperty(value = "sku id")
    private Long skuId;

    @CascadeField(sourceTable = TableInfo.ORDER, linkedTable = TableInfo.EVALUATION, linkedField = "order_id")
    @TableField(value = "order_id")
    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @TableField(value = "images")
    @ApiModelProperty(value = "图片路径")
    private String images;

    @TableField(value = "description")
    @ApiModelProperty(value = "商品描述")
    private String description;

    @TableField(value = "goods_score")
    @ApiModelProperty(value = "商品分")
    private Integer goodsScore;

    @TableField(value = "service_score")
    @ApiModelProperty(value = "服务分")
    private Integer serviceScore;

    @TableField(value = "express_score")
    @ApiModelProperty(value = "物流分")
    private Integer expressScore;

}