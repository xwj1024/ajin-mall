package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 会员表
 *
 * @author Ajin
 */
@ApiModel(value = "会员表")
@Data
@TableName(value = "`member`")
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private Long id;

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

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    @Version
    @ApiModelProperty("版本号")
    private Integer version;

    @TableLogic
    @ApiModelProperty("是否删除")
    private Integer isDelete;
}