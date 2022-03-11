package cn.leemay.mall.sys.goods.mapper;

import cn.leemay.mall.common.data.entity.goods.LabelGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 标签，商品 关联表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Mapper
public interface LabelGoodsMapper extends BaseMapper<LabelGoods> {

}
