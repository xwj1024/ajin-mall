package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.CategoryBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 分类，品牌 关联表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Mapper
public interface CategoryBrandMapper extends BaseMapper<CategoryBrand> {

}
