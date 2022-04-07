package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 权限表
 *
 * @author Ajin
 */
@ApiModel(value = "权限表")
@Data
@TableName(value = "permission")
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private Long id;

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