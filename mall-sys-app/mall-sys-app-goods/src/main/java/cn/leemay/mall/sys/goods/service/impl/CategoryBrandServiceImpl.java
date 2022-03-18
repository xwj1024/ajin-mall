package cn.leemay.mall.sys.goods.service.impl;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.CategoryBrandAddForm;
import cn.leemay.mall.sys.goods.form.CategoryBrandListForm;
import cn.leemay.mall.sys.goods.form.CategoryBrandUpdateForm;
import cn.leemay.mall.sys.goods.service.CategoryBrandService;
import cn.leemay.mall.sys.goods.view.CategoryBrandView;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分类,品牌 关联表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Service
public class CategoryBrandServiceImpl  implements CategoryBrandService {

    @Override
    public void add(CategoryBrandAddForm categoryBrandAddForm) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(CategoryBrandUpdateForm categoryBrandUpdateForm) {

    }

    @Override
    public CategoryBrandView get(Long id) {
        return null;
    }

    @Override
    public ResultPage<CategoryBrandView> list(CategoryBrandListForm categoryBrandListForm) {
        return null;
    }
}
