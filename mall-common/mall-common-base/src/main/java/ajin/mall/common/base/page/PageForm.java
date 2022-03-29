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

    @ApiModelProperty("当前页，默认第1页")
    protected Integer pageIndex = 1;

    @ApiModelProperty("每页条数，默认10条")
    protected Integer pageSize = 10;

    @ApiModelProperty("关键字")
    protected String keyword;

    @ApiModelProperty("排序根据：数据库字段名")
    protected String orderBy;

    @ApiModelProperty("排序规则：升序asc/降序desc")
    protected String sortType;
}
