package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.common.base.util.ObjectUtils;
import cn.leemay.mall.goods.entity.Category;
import cn.leemay.mall.goods.mapper.CategoryMapper;
import cn.leemay.mall.goods.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void insert(Category category) {
        category.setId(null);
        category.setIsDelete(0);
        categoryMapper.insert(category);
    }

    @Override
    public void delete(Long id) {
        categoryMapper.deleteById(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateById(category);
    }

    @Override
    public Category selectOneById(Long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public List<Category> selectListByCondition(Category category) {
        QueryWrapper<Category> queryWrapper = queryWrapper(category);
        return categoryMapper.selectList(queryWrapper);
    }

    @Override
    public Page<Category> selectPageByCondition(Category category, Integer index, Integer size) {
        Page<Category> page = new Page<>(index, size);
        QueryWrapper<Category> queryWrapper = queryWrapper(category);
        return categoryMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Category> selectWithTree() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("is_show", 1);
        // 查询所有要显示的分类
        List<Category> categoryList = categoryMapper.selectByMap(map);
        // 查询所有顶级分类
        return categoryList.stream()
                .filter(category -> category.getParentId() == 0)
                .peek(category -> category.setChild(getChild(category, categoryList)))
                // .sorted(Comparator.comparingInt(Category::getSort))
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
    private List<Category> getChild(Category root, List<Category> all) {
        return all.stream()
                .filter(category -> root.getId().equals(category.getParentId()))
                .peek(category -> category.setChild(getChild(category, all)))
                // .sorted(Comparator.comparingInt(Category::getSort))
                .sorted(Comparator.comparingInt(category -> (category.getSort() == null ? 0 : category.getSort())))
                .collect(Collectors.toList());
    }

    /**
     * 构建条件查询对象
     *
     * @param category 条件
     * @return 对象
     */
    private QueryWrapper<Category> queryWrapper(Category category) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(ObjectUtils.obj2Map(category));
        queryWrapper.orderByAsc("sort");
        return queryWrapper;
    }
}
