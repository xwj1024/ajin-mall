package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Mapper
public interface BrandMapper extends BaseMapper<Brand> {

    /**
     * 根据名称查询数量
     *
     * @param name 名称
     * @return 数量
     */
    Integer selectCountByName(@Param("name") String name);
}
