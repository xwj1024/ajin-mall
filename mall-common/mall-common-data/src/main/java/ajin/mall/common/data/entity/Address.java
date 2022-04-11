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
 * 会员地址表
 *
 * @author Ajin
 */
@ApiModel(value = "会员地址表")
@Data
@TableName(value = "address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "地址id")
    private Long id;

    @CascadeField(sourceTable = TableInfo.MEMBER, linkedTable = TableInfo.ADDRESS, linkedField = "member_id")
    @TableField(value = "member_id")
    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @TableField(value = "province")
    @ApiModelProperty(value = "省")
    private String province;

    @TableField(value = "city")
    @ApiModelProperty(value = "市")
    private String city;

    @TableField(value = "area")
    @ApiModelProperty(value = "区县")
    private String area;

    @TableField(value = "town")
    @ApiModelProperty(value = "乡镇")
    private String town;

    @TableField(value = "detail")
    @ApiModelProperty(value = "详细地址")
    private String detail;

    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableField(value = "is_default")
    @ApiModelProperty(value = "是否默认")
    private Integer isDefault;

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