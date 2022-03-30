package ajin.mall.sys.goods.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.CategoryBrandAddForm;
import ajin.mall.sys.goods.form.CategoryBrandListForm;
import ajin.mall.sys.goods.form.CategoryBrandUpdateForm;
import ajin.mall.sys.goods.view.CategoryBrandView;

/**
 * <p>
 * 分类,商品品牌 关联表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface CategoryBrandService {

    /**
     * 添加商品分类，商品品牌
     *
     * @param categoryBrandAddForm 添加信息
     */
    void add(CategoryBrandAddForm categoryBrandAddForm);

    /**
     * 删除商品分类，商品品牌
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 修改商品分类，商品品牌
     *
     * @param categoryBrandUpdateForm 修改信息
     */
    void update(CategoryBrandUpdateForm categoryBrandUpdateForm);

    /**
     * 根据id查询商品分类，商品品牌
     * @param id id
     * @return
     */
    CategoryBrandView get(Long id);

    ResultPage<CategoryBrandView> list(CategoryBrandListForm categoryBrandListForm);

}
