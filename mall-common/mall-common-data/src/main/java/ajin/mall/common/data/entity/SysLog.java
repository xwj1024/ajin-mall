package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
 * 系统日志表
 *
 * @author Ajin
 */
@ApiModel(value = "系统日志表")
@Data
@TableName(value = "sys_log")
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private Long id;

    @TableField(value = "sys_user_id")
    @ApiModelProperty(value = "系统用户id")
    private Long sysUserId;

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

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    @Version
    @ApiModelProperty("版本号")
    private Integer version;

    @TableLogic
    @ApiModelProperty("是否删除")
    private Integer isDelete;
}