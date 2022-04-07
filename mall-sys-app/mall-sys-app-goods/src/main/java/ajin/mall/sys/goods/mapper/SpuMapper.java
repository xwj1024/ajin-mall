package ajin.mall.sys.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品spu表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface SpuMapper extends BaseMapper<Spu> {
    /**
     * 根据品牌id查询spu数量
     *
     * @param brandId 品牌id
     * @return spu数量
     */
    Integer selectCountByBrandId(@Param("brandId") Long brandId);

    /**
     * 根据分类id查询spu数量
     *
     * @param categoryId 分类id
     * @return spu数量
     */
    Integer selectCountByCategoryId(@Param("categoryId") Long categoryId);
}
