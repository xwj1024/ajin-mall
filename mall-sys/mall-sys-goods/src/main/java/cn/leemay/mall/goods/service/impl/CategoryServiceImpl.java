package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.common.base.asserts.BizAssert;
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

    @Transactional
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

        categoryBrandMapper.deleteByCategoryId(id);
    }

    @Override
    public void updateCategory(CategoryUpdateForm categoryUpdateForm) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryUpdateForm, category);
        categoryMapper.updateById(category);
    }

    @Override
    public CategoryView selectOneById(Long id) {
        Category     category     = categoryMapper.selectById(id);
        CategoryView categoryView = new CategoryView();
        BeanUtils.copyProperties(category, categoryView);
        return categoryView;
    }

    @Override
    public List<CategoryView> selectListByCondition(CategorySelectForm categorySelectForm) {
//        QueryWrapper<Category> queryWrapper = CategoryWrapper.queryWrapper(categorySelectForm);
//        List<Category> categoryList = categoryMapper.selectList(queryWrapper);
//        if (ObjectUtils.isEmpty(categoryList)) {
//            return null;
//        }
//        List<CategoryView> categoryViewList = new ArrayList<>();
//        for (Category category : categoryList) {
//            CategoryView categoryView = new CategoryView();
//            BeanUtils.copyProperties(category, categoryView);
//            categoryViewList.add(categoryView);
//        }
//        return categoryViewList;
        return null;
    }

    @Override
    public ResultPage<CategoryView> selectPageByCondition(CategorySelectForm categorySelectForm, Integer index, Integer size) {
//        Page<Category> page = new Page<>(index, size);
//        QueryWrapper<Category> queryWrapper = CategoryWrapper.queryWrapper(categorySelectForm);
//        Page<Category> categoryPage = categoryMapper.selectPage(page, queryWrapper);
//        if (categoryPage == null || categoryPage.getRecords() == null) {
//            return null;
//        }
//        List<CategoryView> categoryViewList = new ArrayList<>();
//        for (Category category : categoryPage.getRecords()) {
//            CategoryView categoryView = new CategoryView();
//            BeanUtils.copyProperties(category, categoryView);
//            categoryViewList.add(categoryView);
//        }
//        return new ResultPage<>(categoryPage.getTotal(), categoryViewList);
        return null;
    }

    @Override
    public List<CategoryView> selectWithTree() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("is_show", 1);
        // 查询所有要显示的分类
        List<Category> categoryList = categoryMapper.selectByMap(map);
        if (ObjectUtils.isEmpty(categoryList)) {
            return null;
        }
        List<CategoryView> categoryViewList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryView categoryView = new CategoryView();
            BeanUtils.copyProperties(category, categoryView);
            categoryViewList.add(categoryView);
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
