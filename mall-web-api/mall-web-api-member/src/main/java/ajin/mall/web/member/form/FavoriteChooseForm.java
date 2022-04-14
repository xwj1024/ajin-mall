package ajin.mall.web.member.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 收藏添加或取消表单
 *
 * @author Ajin
 * @date 2022/04/13
 */
@ApiModel(value = "收藏添加或取消表单")
@Data
public class FavoriteChooseForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "spu id")
    private Long spuId;

}
