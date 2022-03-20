package ajin.mall.common.base.page;

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
    protected Integer pageIndex;

    @ApiModelProperty("每页条数")
    protected Integer pageSize;

    @ApiModelProperty("关键字")
    protected String keyword;

    @ApiModelProperty("排序根据")
    protected String orderBy;

    @ApiModelProperty("排序规则：asc/desc")
    protected String sortType;
}
