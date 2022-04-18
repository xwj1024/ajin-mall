package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 行政区划表
 *
 * @author Ajin
 */
@ApiModel(value = "行政区划表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "region")
public class Region extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "parent_id")
    @ApiModelProperty(value = "上级id")
    private Long parentId;

    @TableField(value = "code")
    @ApiModelProperty(value = "编码")
    private String code;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "名称")
    private String name;

    @TableField(value = "edition")
    @ApiModelProperty(value = "版本信息：2020版，2022版")
    private String edition;

}