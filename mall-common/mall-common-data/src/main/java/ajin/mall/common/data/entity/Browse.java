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
import java.time.LocalDateTime;

/**
 * 会员浏览记录表
 *
 * @author Ajin
 */
@ApiModel(value = "会员浏览记录表")
@Data
@TableName(value = "`browse`")
@EqualsAndHashCode(callSuper = true)
public class Browse extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @CascadeField(sourceTable = TableInfo.MEMBER, linkedTable = TableInfo.BRAND, linkedField = "member_id")
    @TableField(value = "member_id")
    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @TableField(value = "spu_id")
    @ApiModelProperty(value = "spu id")
    private Long spuId;

    @TableField(value = "browse_time")
    @ApiModelProperty(value = "浏览时间")
    private LocalDateTime browseTime;

}