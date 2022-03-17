package cn.leemay.mall.common.data.entity.goods;

import cn.leemay.mall.common.data.anno.CascadeField;
import cn.leemay.mall.common.data.enums.TableInfo;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品spu表
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "Spu对象", description = "商品spu表")
public class Spu implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("spu名称")
    private String name;

    @ApiModelProperty("商品标题")
    private String caption;

    @ApiModelProperty("商品详情")
    private String details;

    @ApiModelProperty("品牌id")
    private Long brandId;

    @CascadeField(sourceTable = TableInfo.CATEGORY, linkedTable = TableInfo.SPU, linkedField = "category1_id", enableDelete = false)
    @ApiModelProperty("一级分类")
    private Long category1Id;

    @CascadeField(sourceTable = TableInfo.CATEGORY, linkedTable = TableInfo.SPU, linkedField = "category2_id", enableDelete = false)
    @ApiModelProperty("二级分类")
    private Long category2Id;

    @CascadeField(sourceTable = TableInfo.CATEGORY, linkedTable = TableInfo.SPU, linkedField = "category3_id", enableDelete = false)
    @ApiModelProperty("三级分类")
    private Long category3Id;

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
