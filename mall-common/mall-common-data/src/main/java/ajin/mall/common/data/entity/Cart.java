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
 * 会员购物车表
 *
 * @author Ajin
 */
@ApiModel(value = "会员购物车表")
@Data
@TableName(value = "cart")
@EqualsAndHashCode(callSuper = true)
public class Cart extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @CascadeField(sourceTable = TableInfo.MEMBER, linkedTable = TableInfo.CART, linkedField = "member_id")
    @TableField(value = "member_id")
    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @TableField(value = "sku_id")
    @ApiModelProperty(value = "sku id")
    private Long skuId;

    @TableField(value = "num")
    @ApiModelProperty(value = "数量")
    private Integer num;


}