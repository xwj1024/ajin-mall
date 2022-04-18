package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品规格，商品参数  模板表
 *
 * @author Ajin
 */
@ApiModel(value = "商品规格，商品参数  模板表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "`template`")
public class Template extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "category_id")
    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "模板名称")
    private String name;


}