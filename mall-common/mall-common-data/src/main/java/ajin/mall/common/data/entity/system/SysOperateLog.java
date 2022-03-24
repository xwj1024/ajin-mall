package ajin.mall.common.data.entity.system;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Ajin
 */
@Data
public class SysOperateLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "系统用户id")
    private Long sysUserId;

    @ApiModelProperty(value = "操作描述")
    private String description;

    @ApiModelProperty(value = "请求IP")
    private String remoteIp;

    @ApiModelProperty(value = "请求路径")
    private String requestUri;

    @ApiModelProperty(value = "请求方法")
    private String requestMethod;

    @ApiModelProperty(value = "方法名称")
    private String methodName;

    @ApiModelProperty(value = "请求参数")
    private String requestParam;

    @ApiModelProperty(value = "响应结果")
    private String responseResult;

    @ApiModelProperty(value = "原始数据")
    private String sourceData;

    @ApiModelProperty(value = "异常信息")
    private String exceptionInfo;

    @ApiModelProperty(value = "操作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间", hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除")
    @TableLogic
    private String isDelete;

}
