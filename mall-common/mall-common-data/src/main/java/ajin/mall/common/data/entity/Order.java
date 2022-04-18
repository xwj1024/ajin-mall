package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 会员订单表
 *
 * @author Ajin
 */
@ApiModel(value = "会员订单表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "`order`")
public class Order extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


}