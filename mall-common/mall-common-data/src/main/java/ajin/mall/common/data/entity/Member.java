package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 会员表
 *
 * @author Ajin
 */
@ApiModel(value = "会员表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "`member`")
public class Member extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "username")
    @ApiModelProperty(value = "账号")
    private String username;

    @TableField(value = "`password`")
    @ApiModelProperty(value = "密码")
    private String password;

    @TableField(value = "`nickname`")
    @ApiModelProperty(value = "会员昵称")
    private String nickname;

    @TableField(value = "`age`")
    @ApiModelProperty(value = "会员年龄")
    private Integer age;

    @TableField(value = "`phone`")
    @ApiModelProperty(value = "手机号")
    private String phone;

    @TableField(value = "`email`")
    @ApiModelProperty(value = "邮箱")
    private String email;

    @TableField(value = "`level`")
    @ApiModelProperty(value = "会员等级")
    private Integer level;

    @TableField(value = "`state`")
    @ApiModelProperty(value = "状态信息：0全部，1正常")
    private Integer state;

}