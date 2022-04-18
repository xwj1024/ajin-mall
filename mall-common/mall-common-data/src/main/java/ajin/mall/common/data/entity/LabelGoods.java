package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品标签，商品  关联表
 *
 * @author Ajin
 */
@ApiModel(value = "商品标签，商品  关联表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "label_goods")
public class LabelGoods extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "label_id")
    @ApiModelProperty(value = "标签id")
    private Long labelId;

    @TableField(value = "sku_id")
    @ApiModelProperty(value = "sku id")
    private Long skuId;

}