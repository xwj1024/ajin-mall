package ajin.mall.sys.goods.service.impl;

import ajin.mall.common.base.asserts.BizAssert;
import ajin.mall.common.base.page.PageHelp;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.common.data.anno.CascadeDelete;
import ajin.mall.common.data.entity.goods.Category;
import ajin.mall.common.data.enums.TableInfo;
import ajin.mall.sys.goods.form.CategoryAddForm;
import ajin.mall.sys.goods.form.CategoryListForm;
import ajin.mall.sys.goods.form.CategoryUpdateForm;
import ajin.mall.sys.goods.service.CategoryService;
import ajin.mall.sys.goods.view.CategoryView;
import ajin.mall.sys.goods.mapper.CategoryMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品类目表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public void add(CategoryAddForm categoryAddForm) {
        // 判断上级是否存在
        Category existParentCategory = categoryMapper.selectById(categoryAddForm.getParentId());
        BizAssert.isTrue(existParentCategory != null || categoryAddForm.getParentId() == 0, "上级分类不存在");

        // 判断同级是否存在同名分类
        Integer categoryCount = categoryMapper.selectCountByNameAndParentId(categoryAddForm.getName(), categoryAddForm.getParentId());
        BizAssert.isTrue(categoryCount <= 0, "该分类已存在");

        Category category = new Category();
        BeanUtils.copyProperties(categoryAddForm, category);
        int row = categoryMapper.insert(category);
        BizAssert.isTrue(row == 1, "添加失败");
    }

    @CascadeDelete(TableInfo.CATEGORY)
    @Override
    public void delete(Long id) {
        Category existCategory = categoryMapper.selectById(id);
        BizAssert.notNull(existCategory, "该分类不存在");

        int row = categoryMapper.deleteById(id);
        BizAssert.isTrue(row == 1, "删除失败");
    }

    @Override
    public void update(CategoryUpdateForm categoryUpdateForm) {
        // 判断要修改的分类是否存在
        Category existCategory = categoryMapper.selectById(categoryUpdateForm.getId());
        BizAssert.notNull(existCategory, "该分类不存在");

        // 判断上级是否存在
        Category existParentCategory = categoryMapper.selectById(categoryUpdateForm.getParentId());
        BizAssert.isTrue(existParentCategory != null || categoryUpdateForm.getParentId() == 0, "上级分类不存在");

        // 判断同级是否存在同名分类
        Long existCategoryId = categoryMapper.selectIdByNameAndParentId(categoryUpdateForm.getName(), categoryUpdateForm.getParentId());
        BizAssert.isTrue(existCategoryId == null || existCategoryId.equals(categoryUpdateForm.getId()), "该分类已存在");

        BeanUtils.copyProperties(categoryUpdateForm, existCategory);

        int row = categoryMapper.updateById(existCategory);
        BizAssert.isTrue(row == 1, "修改失败");
    }

    @Override
    public CategoryView get(Long id) {
        Category category = categoryMapper.selectById(id);
        BizAssert.notNull(category, "该分类不存在");

        CategoryView categoryView = new CategoryView();
        BeanUtils.copyProperties(category, categoryView);
        return categoryView;
    }

    @Override
    public ResultPage<CategoryView> list(CategoryListForm categoryListForm) {
        PageHelp.startPage(categoryListForm.getPageIndex(), categoryListForm.getPageSize());
        List<CategoryView> list = categoryMapper.selectListByCondition(categoryListForm);
        return new ResultPage<>(new PageInfo<>(list));
    }

    @Override
    public List<CategoryView> tree() {
        // 查询所有要显示的分类
        CategoryListForm categoryListForm = new CategoryListForm();
        categoryListForm.setIsShow(1);
        List<CategoryView> categoryViewList = categoryMapper.selectListByCondition(categoryListForm);
        if (ObjectUtils.isEmpty(categoryViewList)) {
            return categoryViewList;
        }

        // 查询所有顶级分类
        return categoryViewList.stream()
                .filter(categoryView -> categoryView.getParentId() == 0)
                .peek(categoryView -> categoryView.setChild(getChild(categoryView, categoryViewList)))
                // .sorted(Comparator.comparingInt(CategoryView::getSort))
                .sorted(Comparator.comparingInt(category -> (category.getSort() == null ? 0 : category.getSort())))
                .collect(Collectors.toList());
    }

    /**
     * 获取子级分类
     *
     * @param root 父级
     * @param all  所有分类
     * @return 分类列表
     */
    private List<CategoryView> getChild(CategoryView root, List<CategoryView> all) {
        return all.stream()
                .filter(categoryView -> root.getId().equals(categoryView.getParentId()))
                .peek(categoryView -> categoryView.setChild(getChild(categoryView, all)))
                // .sorted(Comparator.comparingInt(CategoryView::getSort))
                .sorted(Comparator.comparingInt(categoryView -> (categoryView.getSort() == null ? 0 : categoryView.getSort())))
                .collect(Collectors.toList());
    }

}
