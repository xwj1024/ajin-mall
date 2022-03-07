package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.Category;
import cn.leemay.mall.goods.entity.form.CategorySelectForm;
import cn.leemay.mall.goods.entity.view.CategoryView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据条件查询分类列表
     *
     * @param categorySelectForm 查询条件
     * @return 分类列表
     */
    List<CategoryView> selectListByCondition(CategorySelectForm categorySelectForm);

}