package ajin.mall.sys.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * api信息
 *
 * @author Ajin
 * @date 2022/04/27
 */
@Data
public class ApiInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "关键字")
    private String keyword;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "方法")
    private String method;

}
