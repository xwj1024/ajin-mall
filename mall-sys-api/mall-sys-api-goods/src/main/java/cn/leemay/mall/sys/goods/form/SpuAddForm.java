package cn.leemay.mall.sys.goods.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-22
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel("Spu添加对象")
public class SpuAddForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("spu名称")
    private String name;

    @ApiModelProperty("商品标题")
    private String caption;

    @ApiModelProperty("商品详情")
    private String details;

    @ApiModelProperty("品牌id")
    private Long brandId;

    @ApiModelProperty("一级分类")
    private Long category1Id;

    @ApiModelProperty("二级分类")
    private Long category2Id;

    @ApiModelProperty("三级分类")
    private Long category3Id;
}
