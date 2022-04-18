package ajin.mall.common.data.entity;

import ajin.mall.common.data.anno.CascadeField;
import ajin.mall.common.data.enums.TableInfo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品分类，商品品牌  关联表
 *
 * @author Ajin
 */
@ApiModel(value = "商品分类，商品品牌  关联表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "category_brand")
public class CategoryBrand extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @CascadeField(sourceTable = TableInfo.CATEGORY, linkedTable = TableInfo.CATEGORY_BRAND, linkedField = "category_id")
    @TableField(value = "category_id")
    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @CascadeField(sourceTable = TableInfo.BRAND, linkedTable = TableInfo.CATEGORY_BRAND, linkedField = "brand_id")
    @TableField(value = "brand_id")
    @ApiModelProperty(value = "品牌id")
    private Long brandId;

}