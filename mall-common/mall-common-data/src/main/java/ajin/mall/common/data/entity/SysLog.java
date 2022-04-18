package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统日志表
 *
 * @author Ajin
 */
@ApiModel(value = "系统日志表")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysLog extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "系统用户id")
    private Long userId;

    @TableField(value = "description")
    @ApiModelProperty(value = "操作描述")
    private String description;

    @TableField(value = "remote_ip")
    @ApiModelProperty(value = "远程IP")
    private String remoteIp;

    @TableField(value = "request_uri")
    @ApiModelProperty(value = "请求路径")
    private String requestUri;

    @TableField(value = "request_method")
    @ApiModelProperty(value = "请求方法")
    private String requestMethod;

    @TableField(value = "method_name")
    @ApiModelProperty(value = "方法名称")
    private String methodName;

    @TableField(value = "request_param")
    @ApiModelProperty(value = "请求参数")
    private String requestParam;

    @TableField(value = "response_result")
    @ApiModelProperty(value = "响应结果")
    private String responseResult;

    @TableField(value = "source_data")
    @ApiModelProperty(value = "原始数据")
    private String sourceData;

    @TableField(value = "exception_info")
    @ApiModelProperty(value = "异常信息")
    private String exceptionInfo;

    @TableField(value = "operate_time")
    @ApiModelProperty(value = "操作时间")
    private LocalDateTime operateTime;


}