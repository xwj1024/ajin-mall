package cn.leemay.mall.sys.goods.mapper;

import cn.leemay.mall.common.data.entity.goods.Category;
import cn.leemay.mall.sys.goods.form.CategoryListForm;
import cn.leemay.mall.sys.goods.view.CategoryView;
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
     * @param categoryListForm 查询条件
     * @return 分类列表
     */
    List<CategoryView> selectListByCondition(CategoryListForm categoryListForm);

}
