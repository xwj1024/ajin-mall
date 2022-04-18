package ajin.mall.common.data.entity;

import ajin.mall.common.data.anno.CascadeField;
import ajin.mall.common.data.enums.TableInfo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 部门表
 *
 * @author Ajin
 */
@ApiModel(value = "部门表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "dept")
public class Dept extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @CascadeField(sourceTable = TableInfo.COMPANY, linkedTable = TableInfo.DEPT, linkedField = "company_id")
    @TableField(value = "company_id")
    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @TableField(value = "`name`")
    @ApiModelProperty(value = "部门名称")
    private String name;

    @TableField(value = "image")
    @ApiModelProperty(value = "部门图片")
    private String image;

    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

}