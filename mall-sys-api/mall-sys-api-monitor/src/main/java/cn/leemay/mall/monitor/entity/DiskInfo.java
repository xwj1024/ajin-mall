package cn.leemay.mall.monitor.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-10-13
 */
@Data
public class DiskInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("盘符路径")
    private String dirName;

    @ApiModelProperty("盘符类型")
    private String dirType;

    @ApiModelProperty("文件类型")
    private String fileType;

    @ApiModelProperty("总大小")
    private String total;

    @ApiModelProperty("剩余")
    private String free;

    @ApiModelProperty("已用")
    private String used;

    @ApiModelProperty("使用率")
    private double usage;

}