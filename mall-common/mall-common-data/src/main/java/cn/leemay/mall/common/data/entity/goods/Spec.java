package cn.leemay.mall.common.data.entity.goods;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品规格表
 * </p>
 *
 * @author Ajin
 * @since 2021-05-22
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "Spec对象", description = "商品规格表")
public class Spec implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("模板id")
    private Long templateId;

    @ApiModelProperty("规格名称")
    private String name;

    @ApiModelProperty("规格选项")
    private String options;

    @ApiModelProperty("是否删除")
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

}
