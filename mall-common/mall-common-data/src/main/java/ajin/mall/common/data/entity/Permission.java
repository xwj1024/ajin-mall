package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 权限表
 *
 * @author Ajin
 */
@ApiModel(value = "权限表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "permission")
public class Permission extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "`name`")
    @ApiModelProperty(value = "名称")
    private String name;

    @TableField(value = "keyword")
    @ApiModelProperty(value = "关键字")
    private String keyword;

    @TableField(value = "`path`")
    @ApiModelProperty(value = "路径")
    private String path;

    @TableField(value = "`method`")
    @ApiModelProperty(value = "方法")
    private String method;

    @TableField(value = "description")
    @ApiModelProperty(value = "备注，描述")
    private String description;

}