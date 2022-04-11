package ajin.mall.common.data.entity;

import ajin.mall.common.data.anno.CascadeField;
import ajin.mall.common.data.enums.TableInfo;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 商品评价表
 *
 * @author Ajin
 */
@ApiModel(value = "商品评价表")
@Data
@TableName(value = "evaluation")
public class Evaluation implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private Long id;

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

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    @Version
    @ApiModelProperty("版本号")
    private Integer version;

    @TableLogic
    @ApiModelProperty("是否删除")
    private Integer isDelete;
}