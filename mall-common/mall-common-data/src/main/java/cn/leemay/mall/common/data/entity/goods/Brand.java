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
 * 品牌表
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "Brand对象", description = "品牌表")
public class Brand implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("品牌id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("品牌图片")
    private String image;

    @ApiModelProperty("首字母")
    private String initials;

    @ApiModelProperty("排序")
    private Integer sort;

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
