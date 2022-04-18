package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户，角色  关联表
 *
 * @author Ajin
 */
@ApiModel(value = "用户，角色  关联表")
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "user_role")
public class UserRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "系统用户id")
    private Long userId;

    @TableField(value = "role_id")
    @ApiModelProperty(value = "系统角色id")
    private Long roleId;


}