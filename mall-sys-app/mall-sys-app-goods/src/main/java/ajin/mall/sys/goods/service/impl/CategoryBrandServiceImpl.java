package ajin.mall.sys.goods.service.impl;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.CategoryBrandAddForm;
import ajin.mall.sys.goods.form.CategoryBrandListForm;
import ajin.mall.sys.goods.form.CategoryBrandUpdateForm;
import ajin.mall.sys.goods.service.CategoryBrandService;
import ajin.mall.sys.goods.view.CategoryBrandView;
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
