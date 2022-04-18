package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 角色，权限  关联表
 *
 * @author Ajin
 */
@ApiModel(value = "角色，权限  关联表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "role_permission")
public class RolePermission extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "role_id")
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @TableField(value = "permission_id")
    @ApiModelProperty(value = "权限id")
    private Long permissionId;


}