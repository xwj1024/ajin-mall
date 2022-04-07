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
 * 商品类目表
 *
 * @author Ajin
 */
@ApiModel(value = "商品类目表")
@Data
@TableName(value = "category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "分类id")
    private Long id;

    @TableField(value = "parent_id")
    @ApiModelProperty(value = "上级id")
    private Long parentId;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "分类名称")
    private String name;

    @TableField(value = "image")
    @ApiModelProperty(value = "分类图片")
    private String image;

    @TableField(value = "`level`")
    @ApiModelProperty(value = "分类级别")
    private Integer level;

    @TableField(value = "sort")
    @ApiModelProperty(value = "分类排序")
    private Integer sort;

    @TableField(value = "is_show")
    @ApiModelProperty(value = "是否显示")
    private Integer isShow;

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