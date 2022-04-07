package ajin.mall.sys.goods.mapper;

import ajin.mall.sys.goods.form.SkuListForm;
import ajin.mall.sys.goods.view.SkuView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品sku表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface SkuMapper extends BaseMapper<Sku> {

    List<SkuView> selectListByCondition(SkuListForm skuListForm);
}
