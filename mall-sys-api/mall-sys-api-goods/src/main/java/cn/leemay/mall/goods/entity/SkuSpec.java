package cn.leemay.mall.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品,规格 关联表
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "SkuSpec对象", description = "商品，规格  关联表")
public class SkuSpec implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("sku id")
    private Long skuId;

    @ApiModelProperty("规格名")
    private String name;

    @ApiModelProperty("规格值")
    private String value;


}