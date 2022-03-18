package cn.leemay.mall.sys.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.CategoryBrandAddForm;
import cn.leemay.mall.sys.goods.form.CategoryBrandListForm;
import cn.leemay.mall.sys.goods.form.CategoryBrandUpdateForm;
import cn.leemay.mall.sys.goods.view.CategoryBrandView;

/**
 * <p>
 * 分类,品牌 关联表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface CategoryBrandService {

    void add(CategoryBrandAddForm categoryBrandAddForm);

    void delete(Long id);

    void update(CategoryBrandUpdateForm categoryBrandUpdateForm);

    CategoryBrandView get(Long id);

    ResultPage<CategoryBrandView> list(CategoryBrandListForm categoryBrandListForm);

}
