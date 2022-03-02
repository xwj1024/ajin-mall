package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.Spu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品spu表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Mapper
public interface SpuMapper extends BaseMapper<Spu> {
    /**
     * 根据品牌id查询spu
     *
     * @param brandId 品牌id
     * @return spu数量
     */
    Integer selectCountByBrandId(@Param("brandId") Long brandId);
}
