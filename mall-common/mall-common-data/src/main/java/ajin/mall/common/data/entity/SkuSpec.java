package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品，商品规格  关联表
 *
 * @author Ajin
 */
@ApiModel(value = "商品，商品规格  关联表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sku_spec")
public class SkuSpec extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "sku_id")
    @ApiModelProperty(value = "sku id")
    private Long skuId;

    @TableField(value = "spec_id")
    @ApiModelProperty(value = "规格id")
    private Long specId;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "规格名")
    private String name;

    @TableField(value = "`value`")
    @ApiModelProperty(value = "规格值")
    private String value;


}