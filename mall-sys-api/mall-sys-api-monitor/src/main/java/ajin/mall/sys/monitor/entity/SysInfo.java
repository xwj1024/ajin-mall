package ajin.mall.sys.monitor.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-10-13
 */
@Data
public class SysInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("名称")
    private String computerName;

    @ApiModelProperty("ip")
    private String computerIp;

    @ApiModelProperty("系统名称")
    private String osName;

    @ApiModelProperty("系统架构")
    private String osArch;

    @ApiModelProperty("系统版本")
    private String osVersion;

}