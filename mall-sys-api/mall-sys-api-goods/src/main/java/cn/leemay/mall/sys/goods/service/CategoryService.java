package cn.leemay.mall.sys.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.CategoryAddForm;
import cn.leemay.mall.sys.goods.form.CategoryGetForm;
import cn.leemay.mall.sys.goods.form.CategoryUpdateForm;
import cn.leemay.mall.sys.goods.view.CategoryView;

import java.util.List;

/**
 * <p>
 * 商品类目表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface CategoryService {

    /**
     * 添加分类
     *
     * @param categoryAddForm 分类
     */
    void insertCategory(CategoryAddForm categoryAddForm);

    /**
     * 根据id删除分类
     *
     * @param id 主键id
     */
    void deleteCategory(Long id);

    /**
     * 修改分类
     *
     * @param categoryUpdateForm 分类
     */
    void updateCategory(CategoryUpdateForm categoryUpdateForm);

    /**
     * 根据id查询分类
     *
     * @param id id
     * @return 分类
     */
    CategoryView selectOne(Long id);

    /**
     * 根据条件查询分类
     *
     * @param categoryGetForm 分类条件
     * @return 分类列表
     */
    ResultPage<CategoryView> selectList(CategoryGetForm categoryGetForm);

    /**
     * 树形结构查询
     *
     * @return 所有显示分类以树形结构
     */
    List<CategoryView> selectWithTree();
}
