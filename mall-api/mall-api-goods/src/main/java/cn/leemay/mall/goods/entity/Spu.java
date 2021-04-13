package cn.leemay.mall.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品spu表
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Spu对象", description = "商品spu表")
public class Spu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "spu名称")
    private String name;

    @ApiModelProperty(value = "商品标题")
    private String caption;

    @ApiModelProperty(value = "商品详情")
    private String details;

    @ApiModelProperty(value = "品牌id")
    private Long brandId;

    @ApiModelProperty(value = "一级分类")
    private Long category1Id;

    @ApiModelProperty(value = "二级分类")
    private Long category2Id;

    @ApiModelProperty(value = "三级分类")
    private Long category3Id;

    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private Integer isDelete;


}
