package cn.leemay.mall.sys.monitor.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-10-13
 */
@Data
public class JvmInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("当前JVM占用的内存总数(MB)")
    private double totalMemory;

    @ApiModelProperty("JVM最大可用内存总数(MB)")
    private double maxMemory;

    @ApiModelProperty("JVM空闲内存(MB)")
    private double freeMemory;

    @ApiModelProperty("JDK版本")
    private String version;

    @ApiModelProperty("JDK路径")
    private String home;

    @ApiModelProperty("JDK名称")
    private String name;

    @ApiModelProperty("启动时间")
    private String startTime;

    @ApiModelProperty("运行时间")
    private String runTime;
}