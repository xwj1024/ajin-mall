package cn.leemay.mall.common.base.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-8-24
 */
@Data
public class PageForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("当前页")
    protected Integer index;

    @ApiModelProperty("每页条数")
    protected Integer size;

    @ApiModelProperty("关键字")
    protected String keyword;

    @ApiModelProperty("每页条数")
    protected String orderBy;

    @ApiModelProperty("每页条数")
    protected String sortType;
}