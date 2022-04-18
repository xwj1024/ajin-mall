package ajin.mall.common.data.entity;

import ajin.mall.common.data.anno.CascadeField;
import ajin.mall.common.data.enums.TableInfo;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 收件地址表
 *
 * @author Ajin
 * @date 2022/04/13
 */
@ApiModel(value = "收件地址表")
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "address")
public class Address extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @CascadeField(sourceTable = TableInfo.MEMBER, linkedTable = TableInfo.ADDRESS, linkedField = "member_id")
    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "收件人")
    private String addressee;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区县")
    private String area;

    @ApiModelProperty(value = "乡镇街道")
    private String town;

    @ApiModelProperty(value = "详细地址")
    private String detail;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否默认")
    private Integer isDefault;

}