package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品规格表
 *
 * @author Ajin
 */
@ApiModel(value = "商品规格表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "spec")
public class Spec extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "template_id")
    @ApiModelProperty(value = "模板id")
    private Long templateId;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "规格名称")
    private String name;

    @TableField(value = "`options`")
    @ApiModelProperty(value = "规格选项")
    private String options;


}