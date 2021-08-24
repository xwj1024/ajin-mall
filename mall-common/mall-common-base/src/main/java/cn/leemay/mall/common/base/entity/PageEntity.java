package cn.leemay.mall.common.base.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-8-24
 */
@Data
public class PageEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("当前页")
    private Integer index;

    @ApiModelProperty("每页条数")
    private Integer size;
}
