package ajin.mall.sys.goods.mapper;

import ajin.mall.common.data.entity.goods.Category;
import ajin.mall.sys.goods.form.CategoryListForm;
import ajin.mall.sys.goods.view.CategoryView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface CategoryMapper extends BaseMapper<Category> {
    /**
     * 根据名称和父id查询商品分类数量
     *
     * @param name     名称
     * @param parentId 父id
     * @return 商品分类数量
     */
    Integer selectCountByNameAndParentId(@Param("name") String name, @Param("parentId") Long parentId);

    /**
     * 根据父id查询商品分类数量
     *
     * @param parentId 父id
     * @return 商品分类数量
     */
    Integer selectCountByParentId(@Param("parentId") Long parentId);

    /**
     * 根据条件查询商品分类列表
     *
     * @param categoryListForm 查询条件
     * @return 商品分类列表
     */
    List<CategoryView> selectListByCondition(CategoryListForm categoryListForm);

    /**
     * 根据名称和父级id查询
     *
     * @param name     名称
     * @param parentId 父id
     * @return id
     */
    Long selectIdByNameAndParentId(@Param("name") String name, @Param("parentId") Long parentId);
}
