package cn.leemay.mall.monitor.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ajin
 * @since 2021-10-13
 */
@Data
public class ServerInfo implements Serializable {

    public static final int OSHI_WAIT = 1000;
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("磁盘信息")
    private List<DiskInfo> diskInfoList;

    @ApiModelProperty("cpu信息")
    private CpuInfo cpuInfo;

    @ApiModelProperty("内存信息")
    private MemInfo memInfo;

    @ApiModelProperty("系统信息")
    private SysInfo sysInfo;

    @ApiModelProperty("jvm信息")
    private JvmInfo jvmInfo;


}