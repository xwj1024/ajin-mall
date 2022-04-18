package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品，商品参数  关联表
 *
 * @author Ajin
 */
@ApiModel(value = "商品，商品参数  关联表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "spu_param")
public class SpuParam extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "spu_id")
    @ApiModelProperty(value = "spu id")
    private Long spuId;

    @TableField(value = "param_id")
    @ApiModelProperty(value = "参数id")
    private Long paramId;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "参数名")
    private String name;

    @TableField(value = "`value`")
    @ApiModelProperty(value = "参数值")
    private String value;


}