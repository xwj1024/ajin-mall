package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品sku表
 *
 * @author Ajin
 */
@ApiModel(value = "商品sku表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sku")
public class Sku extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "spu_id")
    @ApiModelProperty(value = "spu id")
    private Long spuId;

    @TableField(value = "sn")
    @ApiModelProperty(value = "商品条码")
    private String sn;

    @TableField(value = "code")
    @ApiModelProperty(value = "商品编号")
    private String code;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "sku名称")
    private String name;

    @TableField(value = "images")
    @ApiModelProperty(value = "商品图片")
    private String images;

    @TableField(value = "market_price")
    @ApiModelProperty(value = "市场价,元")
    private BigDecimal marketPrice;

    @TableField(value = "cheap_price")
    @ApiModelProperty(value = "优惠价,元")
    private BigDecimal cheapPrice;

    @TableField(value = "cost_price")
    @ApiModelProperty(value = "成本价,元")
    private BigDecimal costPrice;

    @TableField(value = "qrcode")
    @ApiModelProperty(value = "二维码")
    private String qrcode;

    @TableField(value = "stock_num")
    @ApiModelProperty(value = "库存数量")
    private Integer stockNum;

    @TableField(value = "alert_num")
    @ApiModelProperty(value = "库存预警数")
    private Integer alertNum;

    @TableField(value = "sale_num")
    @ApiModelProperty(value = "商品销量")
    private Integer saleNum;

    @TableField(value = "evaluate_num")
    @ApiModelProperty(value = "评论数")
    private Integer evaluateNum;

    @TableField(value = "is_check")
    @ApiModelProperty(value = "是否审核")
    private Integer isCheck;

    @TableField(value = "is_market")
    @ApiModelProperty(value = "是否上架")
    private Integer isMarket;

    @TableField(value = "is_invalid")
    @ApiModelProperty(value = "是否作废")
    private Integer isInvalid;

    @TableField(value = "on_market_time")
    @ApiModelProperty(value = "上架时间")
    private LocalDateTime onMarketTime;

    @TableField(value = "off_market_time")
    @ApiModelProperty(value = "下架时间")
    private LocalDateTime offMarketTime;


}