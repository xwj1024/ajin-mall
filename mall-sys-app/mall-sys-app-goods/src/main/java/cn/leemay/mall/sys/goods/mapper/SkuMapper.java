package cn.leemay.mall.sys.goods.mapper;

import cn.leemay.mall.common.data.entity.goods.Sku;
import cn.leemay.mall.sys.goods.form.SkuListForm;
import cn.leemay.mall.sys.goods.view.SkuView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 商品sku表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Mapper
public interface SkuMapper extends BaseMapper<Sku> {

    List<SkuView> selectListByCondition(SkuListForm skuListForm);
}
