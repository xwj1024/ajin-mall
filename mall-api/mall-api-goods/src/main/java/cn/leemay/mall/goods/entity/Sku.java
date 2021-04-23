package cn.leemay.mall.goods.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品sku表
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Sku对象", description = "商品sku表")
public class Sku implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "spu id")
    private Long spuId;

    @ApiModelProperty(value = "商品条码")
    private String sn;

    @ApiModelProperty(value = "商品编号")
    private String code;

    @ApiModelProperty(value = "sku名称")
    private String name;

    @ApiModelProperty(value = "商品图片")
    private String images;

    @ApiModelProperty(value = "商品重量,克")
    private BigDecimal weight;

    @ApiModelProperty(value = "市场价,元")
    private BigDecimal marketPrice;

    @ApiModelProperty(value = "优惠价,元")
    private BigDecimal cheapPrice;

    @ApiModelProperty(value = "成本价,元")
    private BigDecimal costPrice;

    @ApiModelProperty(value = "二维码")
    private String qrcode;

    @ApiModelProperty(value = "库存数量")
    private Integer sumNum;

    @ApiModelProperty(value = "库存预警数")
    private Integer alertNum;

    @ApiModelProperty(value = "商品销量")
    private Integer saleNum;

    @ApiModelProperty(value = "评论数")
    private Integer commentNum;

    @ApiModelProperty(value = "是否审核")
    private Integer isCheck;

    @ApiModelProperty(value = "是否上架")
    private Integer isMarket;

    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
