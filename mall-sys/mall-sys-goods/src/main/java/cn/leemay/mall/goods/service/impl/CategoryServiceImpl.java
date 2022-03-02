package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.common.base.exception.BizException;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.Category;
import cn.leemay.mall.goods.entity.form.SpuSelectForm;
import cn.leemay.mall.goods.entity.view.CategoryView;
import cn.leemay.mall.goods.entity.form.CategoryInsertForm;
import cn.leemay.mall.goods.entity.form.CategorySelectForm;
import cn.leemay.mall.goods.entity.form.CategoryUpdateForm;
import cn.leemay.mall.goods.mapper.CategoryMapper;
import cn.leemay.mall.goods.mapper.SpuMapper;
import cn.leemay.mall.goods.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public void insertCategory(CategoryInsertForm categoryInsertForm) {
//        CategorySelectForm categorySelectForm = new CategorySelectForm();
//        categorySelectForm.setName(categoryInsertForm.getName());
//        categorySelectForm.setParentId(categoryInsertForm.getParentId());
//        Integer categoryCount = categoryMapper.selectCount(CategoryWrapper.queryCountWrapper(categorySelectForm));
//        if (categoryCount > 0) {
//            throw new BizException("已有该分类");
//        }
//        Category category = new Category();
//        BeanUtils.copyProperties(categoryInsertForm, category);
//        categoryMapper.insert(category);
    }

    @Override
    public void deleteCategory(Long id) {
//        CategorySelectForm categorySelectForm = new CategorySelectForm();
//        categorySelectForm.setParentId(id);
//        Integer categoryCount = categoryMapper.selectCount(CategoryWrapper.queryCountWrapper(categorySelectForm));
//        if (categoryCount > 0) {
//            throw new BizException("该分类已关联下级分类");
//        }
//        SpuSelectForm spuSelectForm = new SpuSelectForm();
//        spuSelectForm.setCategory3Id(id);
//        Integer spuCount = spuMapper.selectCount(SpuWrapper.queryCountWrapper(spuSelectForm));
//        if (spuCount > 0) {
//            throw new BizException("该分类已关联商品");
//        }
//        categoryMapper.deleteById(id);
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
