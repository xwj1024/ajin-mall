package ajin.mall.sys.member.form;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 */
@ApiModel(value = "会员添加")
@Data
public class MemberAddForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账号")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "会员昵称")
    private Integer nickname;

    @ApiModelProperty(value = "会员年龄")
    private Integer age;
    @TableField(value = "`phone`")
    @ApiModelProperty(value = "手机号")
    private Integer phone;

    @ApiModelProperty(value = "邮箱")
    private Integer email;

    @ApiModelProperty(value = "会员等级")
    private Integer level;
}
