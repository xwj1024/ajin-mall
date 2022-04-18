package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 公司表
 *
 * @author Ajin
 */
@ApiModel(value = "公司表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "company")
public class Company extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "公司名称")
    private String name;

    @TableField(value = "image")
    @ApiModelProperty(value = "公司图片")
    private String image;

}