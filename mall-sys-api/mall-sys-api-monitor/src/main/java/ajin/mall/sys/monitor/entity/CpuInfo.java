package ajin.mall.sys.monitor.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-10-13
 */
@Data
public class CpuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("核心数")
    private int cpuNum;

    @ApiModelProperty("CPU总的使用率")
    private double totalRate;

    @ApiModelProperty("CPU系统使用率")
    private double sysRate;

    @ApiModelProperty("CPU用户使用率")
    private double usedRate;

    @ApiModelProperty("CPU当前等待率")
    private double waitRate;

    @ApiModelProperty("CPU当前空闲率")
    private double freeRate;
}