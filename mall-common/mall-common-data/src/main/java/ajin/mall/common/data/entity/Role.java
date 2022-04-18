package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 角色表
 *
 * @author Ajin
 */
@ApiModel(value = "角色表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "`role`")
public class Role extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "`name`")
    @ApiModelProperty(value = "名称")
    private String name;

    @TableField(value = "keyword")
    @ApiModelProperty(value = "关键字")
    private String keyword;

    @TableField(value = "description")
    @ApiModelProperty(value = "备注，描述")
    private String description;

    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;


}