package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品类目表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    /**
     * 根据名称和父id查询分类数量
     *
     * @param name     名称
     * @param parentId 父id
     * @return 分类数量
     */
    Integer selectCountByNameAndParentId(@Param("name") String name, @Param("parentId") Long parentId);

    /**
     * 根据父id查询分类数量
     *
     * @param parentId 父id
     * @return 分类数量
     */
    Integer selectCountByParentId(@Param("parentId") Long parentId);
}
