package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品标签表
 *
 * @author Ajin
 */
@ApiModel(value = "商品标签表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "`label`")
public class Label extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "标签名称")
    private String name;

    @TableField(value = "image")
    @ApiModelProperty(value = "标签图片")
    private String image;

    @TableField(value = "`type`")
    @ApiModelProperty(value = "标签类型")
    private Integer type;

    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

}