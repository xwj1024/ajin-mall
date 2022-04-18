package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表
 *
 * @author Ajin
 */
@ApiModel(value = "用户表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "`user`")
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "username")
    @ApiModelProperty(value = "账号")
    private String username;

    @TableField(value = "`password`")
    @ApiModelProperty(value = "密码")
    private String password;

    @TableField(value = "nickname")
    @ApiModelProperty(value = "昵称")
    private String nickname;

    @TableField(value = "avatar")
    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "备注，描述")
    private String remark;

    @TableField(value = "`state`")
    @ApiModelProperty(value = "状态信息：0全部，1账号正常，2账号禁用，4账号锁定，8账号过期，16密码过期")
    private Integer state;

    @TableField(value = "login_time")
    @ApiModelProperty(value = "登录时间")
    private LocalDateTime loginTime;


}