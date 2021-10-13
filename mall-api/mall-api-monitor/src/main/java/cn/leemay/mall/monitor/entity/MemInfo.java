package cn.leemay.mall.monitor.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-10-13
 */
@Data
public class MemInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("内存总量")
    private double total;

    @ApiModelProperty("已用内存")
    private double used;

    @ApiModelProperty("剩余内存")
    private double free;
}