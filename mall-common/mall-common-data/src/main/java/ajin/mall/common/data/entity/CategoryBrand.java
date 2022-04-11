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
 * 商品分类，商品品牌  关联表
 *
 * @author Ajin
 */
@ApiModel(value = "商品分类，商品品牌  关联表")
@Data
@TableName(value = "category_brand")
public class CategoryBrand implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @CascadeField(sourceTable = TableInfo.CATEGORY, linkedTable = TableInfo.CATEGORY_BRAND, linkedField = "category_id")
    @TableField(value = "category_id")
    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @CascadeField(sourceTable = TableInfo.BRAND, linkedTable = TableInfo.CATEGORY_BRAND, linkedField = "brand_id")
    @TableField(value = "brand_id")
    @ApiModelProperty(value = "品牌id")
    private Long brandId;

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