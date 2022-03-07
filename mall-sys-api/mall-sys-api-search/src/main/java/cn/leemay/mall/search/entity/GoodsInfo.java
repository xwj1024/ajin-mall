package cn.leemay.mall.search.entity;

import cn.leemay.mall.search.anno.EsField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Ajin
 * @since 2021-04-20
 */
@Data
public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @EsField(type = "keyword")
    private Long id;

    @EsField(type = "keyword")
    private Long spuId;

    @EsField(analyzer = "ik_max_word")
    private String name;

    @EsField(index = false)
    private String images;

    @EsField(type = "keyword")
    private BigDecimal marketPrice;

    @EsField(type = "keyword")
    private BigDecimal cheapPrice;

    @EsField(type = "keyword")
    private Integer sumNum;

    @EsField(type = "keyword")
    private Integer saleNum;

    @EsField(type = "keyword")
    private Integer commentNum;
}
