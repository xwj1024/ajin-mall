package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.common.base.asserts.BizAssert;
import cn.leemay.mall.common.base.page.PageHelp;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.Category;
import cn.leemay.mall.goods.entity.form.CategoryInsertForm;
import cn.leemay.mall.goods.entity.form.CategorySelectForm;
import cn.leemay.mall.goods.entity.form.CategoryUpdateForm;
import cn.leemay.mall.goods.entity.view.CategoryView;
import cn.leemay.mall.goods.mapper.CategoryBrandMapper;
import cn.leemay.mall.goods.mapper.CategoryMapper;
import cn.leemay.mall.goods.mapper.SpuMapper;
import cn.leemay.mall.goods.service.CategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.*;
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

    @Resource
    private SpuMapper spuMapper;

    @Resource
    private CategoryBrandMapper categoryBrandMapper;

    @Override
    public void insertCategory(CategoryInsertForm categoryInsertForm) {
        Integer categoryCount = categoryMapper.selectCountByNameAndParentId(categoryInsertForm.getName(), categoryInsertForm.getParentId());
        BizAssert.isTrue(categoryCount <= 0, "已有该分类");

        Category category = new Category();
        BeanUtils.copyProperties(categoryInsertForm, category);
        int row = categoryMapper.insert(category);
        BizAssert.isTrue(row == 1, "添加失败");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteCategory(Long id) {
        Category existCategory = categoryMapper.selectById(id);
        BizAssert.notNull(existCategory, "分类不存在");

        Integer categoryCount = categoryMapper.selectCountByParentId(id);
        BizAssert.isTrue(categoryCount <= 0, "该分类已关联下级分类");

        Integer spuCount = spuMapper.selectCountByCategoryId(id);
        BizAssert.isTrue(spuCount <= 0, "该分类已关联商品");

        int row = categoryMapper.deleteById(id);
        BizAssert.isTrue(row == 1, "删除失败");

        // 删除分类品牌中间表
        categoryBrandMapper.deleteByCategoryId(id);
    }

    @Override
    public void updateCategory(CategoryUpdateForm categoryUpdateForm) {
        Category existCategory = categoryMapper.selectById(categoryUpdateForm.getId());
        BizAssert.notNull(existCategory, "分类不存在");

        Integer categoryCount = categoryMapper.selectCountByNameAndParentId(categoryUpdateForm.getName(), categoryUpdateForm.getParentId());
        BizAssert.isTrue(categoryCount <= 0, "已有该分类");

        Category category = new Category();
        BeanUtils.copyProperties(categoryUpdateForm, category);

        int row = categoryMapper.updateById(category);
        BizAssert.isTrue(row == 1, "修改失败");
    }

    @Override
    public CategoryView selectOne(Long id) {
        Category     category     = categoryMapper.selectById(id);
        CategoryView categoryView = new CategoryView();
        BeanUtils.copyProperties(category, categoryView);
        return categoryView;
    }

    @Override
    public ResultPage<CategoryView> selectList(CategorySelectForm categorySelectForm) {
        PageHelp.startPage(categorySelectForm.getPageIndex(), categorySelectForm.getPageSize());
        List<CategoryView> list = categoryMapper.selectListByCondition(categorySelectForm);
        return new ResultPage<>(new PageInfo<>(list));
    }

    @Override
    public List<CategoryView> selectWithTree() {
        // 查询所有要显示的分类
        CategorySelectForm categorySelectForm = new CategorySelectForm();
        categorySelectForm.setIsShow(1);
        List<CategoryView> categoryViewList = categoryMapper.selectListByCondition(categorySelectForm);
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
