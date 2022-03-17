package cn.leemay.mall.sys.goods.form;

import cn.leemay.mall.common.base.page.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel("品牌查询对象")
public class BrandGetForm extends PageForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("首字母")
    private String initials;

}
