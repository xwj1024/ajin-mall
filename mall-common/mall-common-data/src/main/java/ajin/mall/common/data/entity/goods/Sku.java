package ajin.mall.common.data.entity.goods;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品sku表
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "Sku对象", description = "商品sku表")
public class Sku implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("spu id")
    private Long spuId;

    @ApiModelProperty("商品条码")
    private String sn;

    @ApiModelProperty("商品编号")
    private String code;

    @ApiModelProperty("sku名称")
    private String name;

    @ApiModelProperty("商品图片")
    private String images;

    @ApiModelProperty("商品重量,克")
    private BigDecimal weight;

    @ApiModelProperty("市场价,元")
    private BigDecimal marketPrice;

    @ApiModelProperty("优惠价,元")
    private BigDecimal cheapPrice;

    @ApiModelProperty("成本价,元")
    private BigDecimal costPrice;

    @ApiModelProperty("二维码")
    private String qrcode;

    @ApiModelProperty("库存数量")
    private Integer sumNum;

    @ApiModelProperty("库存预警数")
    private Integer alertNum;

    @ApiModelProperty("商品销量")
    private Integer saleNum;

    @ApiModelProperty("评论数")
    private Integer commentNum;

    @ApiModelProperty("是否审核")
    private Integer isCheck;

    @ApiModelProperty("是否上架")
    private Integer isMarket;

    @ApiModelProperty("是否删除")
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;


}
