package cn.leemay.mall.common.data.entity.goods;

import cn.leemay.mall.common.data.anno.CascadeField;
import cn.leemay.mall.common.data.enums.TableInfo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 分类,品牌 关联表
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "CategoryBrand对象", description = "分类，品牌  关联表")
public class CategoryBrand implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @CascadeField(sourceTable = TableInfo.CATEGORY, linkedTable = TableInfo.CATEGORY_BRAND, linkedField = "category_id")
    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("品牌id")
    private Long brandId;


}
