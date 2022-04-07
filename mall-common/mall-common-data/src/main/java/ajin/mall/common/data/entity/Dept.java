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
 * 部门表
 *
 * @author Ajin
 */
@ApiModel(value = "部门表")
@Data
@TableName(value = "dept")
public class Dept implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "部门id")
    private Long id;

    @TableField(value = "company_id")
    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "部门名称")
    private String name;

    @TableField(value = "image")
    @ApiModelProperty(value = "部门图片")
    private String image;

    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

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