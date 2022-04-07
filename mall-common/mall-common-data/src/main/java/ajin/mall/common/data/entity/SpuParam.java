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
 * 商品，商品参数  关联表
 *
 * @author Ajin
 */
@ApiModel(value = "商品，商品参数  关联表")
@Data
@TableName(value = "spu_param")
public class SpuParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @TableField(value = "spu_id")
    @ApiModelProperty(value = "spu id")
    private Long spuId;

    @TableField(value = "param_id")
    @ApiModelProperty(value = "参数id")
    private Long paramId;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "参数名")
    private String name;

    @TableField(value = "`value`")
    @ApiModelProperty(value = "参数值")
    private String value;

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