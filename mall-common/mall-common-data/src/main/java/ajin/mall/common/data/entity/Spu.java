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
 * 商品spu表
 *
 * @author Ajin
 */
@ApiModel(value = "商品spu表")
@Data
@TableName(value = "spu")
public class Spu implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "spu名称")
    private String name;

    @TableField(value = "caption")
    @ApiModelProperty(value = "商品标题")
    private String caption;

    @TableField(value = "details")
    @ApiModelProperty(value = "商品详情")
    private String details;

    @TableField(value = "brand_id")
    @ApiModelProperty(value = "品牌id")
    private Long brandId;

    @TableField(value = "category1_id")
    @ApiModelProperty(value = "一级分类")
    private Long category1Id;

    @TableField(value = "category2_id")
    @ApiModelProperty(value = "二级分类")
    private Long category2Id;

    @TableField(value = "category3_id")
    @ApiModelProperty(value = "三级分类")
    private Long category3Id;

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