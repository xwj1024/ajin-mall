package ajin.mall.common.data.entity;

import ajin.mall.common.data.anno.CascadeField;
import ajin.mall.common.data.enums.TableInfo;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 会员收藏表
 *
 * @author Ajin
 */
@ApiModel(value = "会员收藏表")
@Data
@TableName(value = "favorite")
public class Favorite implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @CascadeField(sourceTable = TableInfo.MEMBER, linkedTable = TableInfo.FAVORITE, linkedField = "member_id")
    @TableField(value = "member_id")
    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @CascadeField(sourceTable = TableInfo.SPU, linkedTable = TableInfo.FAVORITE, linkedField = "spu_id")
    @TableField(value = "spu_id")
    @ApiModelProperty(value = "spu id")
    private Long spuId;

    @TableField(value = "favorite_time")
    @ApiModelProperty(value = "收藏时间")
    private LocalDateTime favoriteTime;

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