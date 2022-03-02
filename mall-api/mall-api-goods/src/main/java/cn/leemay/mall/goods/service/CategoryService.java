package cn.leemay.mall.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.form.CategoryInsertForm;
import cn.leemay.mall.goods.entity.form.CategorySelectForm;
import cn.leemay.mall.goods.entity.form.CategoryUpdateForm;
import cn.leemay.mall.goods.entity.view.CategoryView;

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
     * @param categoryInsertForm 分类
     */
    void insertCategory(CategoryInsertForm categoryInsertForm);

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
    CategoryView selectOneById(Long id);

    /**
     * 根据条件查询分类
     *
     * @param categorySelectForm 分类条件
     * @return 分类列表
     */
    List<CategoryView> selectListByCondition(CategorySelectForm categorySelectForm);

    /**
     * 根据条件分页查询分类
     *
     * @param categorySelectForm 分类条件
     * @param index              当前页
     * @param size               每页数
     * @return 分页分类
     */
    ResultPage<CategoryView> selectPageByCondition(CategorySelectForm categorySelectForm, Integer index, Integer size);

    /**
     * 树形结构查询
     *
     * @return 所有显示分类以树形结构
     */
    List<CategoryView> selectWithTree();
}
