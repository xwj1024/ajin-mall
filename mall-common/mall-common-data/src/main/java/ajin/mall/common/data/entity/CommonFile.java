package ajin.mall.common.data.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 公共文件表
 *
 * @author Ajin
 */
@ApiModel(value = "公共文件表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "common_file")
public class CommonFile extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


}