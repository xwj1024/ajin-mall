package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品运费表
 *
 * @author Ajin
 */
@ApiModel(value = "商品运费表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "freight")
public class Freight extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


}