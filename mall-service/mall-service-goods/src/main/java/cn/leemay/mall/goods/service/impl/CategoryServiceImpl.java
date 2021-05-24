package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.common.base.exception.BusException;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.Brand;
import cn.leemay.mall.goods.entity.Category;
import cn.leemay.mall.goods.entity.Spu;
import cn.leemay.mall.goods.entity.dto.BrandDTO;
import cn.leemay.mall.goods.entity.dto.CategoryDTO;
import cn.leemay.mall.goods.entity.vo.CategoryInsertVO;
import cn.leemay.mall.goods.entity.vo.CategorySelectVO;
import cn.leemay.mall.goods.entity.vo.CategoryUpdateVO;
import cn.leemay.mall.goods.entity.vo.SpuSelectVO;
import cn.leemay.mall.goods.mapper.CategoryMapper;
import cn.leemay.mall.goods.mapper.SpuMapper;
import cn.leemay.mall.goods.service.CategoryService;
import cn.leemay.mall.goods.wrapper.CategoryWrapper;
import cn.leemay.mall.goods.wrapper.SpuWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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
    public void insertCategory(CategoryInsertVO categoryInsertVO) {
        CategorySelectVO categorySelectVO = new CategorySelectVO();
        categorySelectVO.setName(categoryInsertVO.getName());
        categorySelectVO.setParentId(categoryInsertVO.getParentId());
        Integer categoryCount = categoryMapper.selectCount(CategoryWrapper.queryCountWrapper(categorySelectVO));
        if (categoryCount > 0) {
            throw new BusException("已有该分类");
        }
        Category category = new Category();
        BeanUtils.copyProperties(categoryInsertVO, category);
        categoryMapper.insert(category);
    }

    @Override
    public void deleteCategory(Long id) {
        CategorySelectVO categorySelectVO = new CategorySelectVO();
        categorySelectVO.setParentId(id);
        Integer categoryCount = categoryMapper.selectCount(CategoryWrapper.queryCountWrapper(categorySelectVO));
        if (categoryCount > 0) {
            throw new BusException("该分类已关联下级分类");
        }
        SpuSelectVO spuSelectVO = new SpuSelectVO();
        spuSelectVO.setCategory3Id(id);
        Integer spuCount = spuMapper.selectCount(SpuWrapper.queryCountWrapper(spuSelectVO));
        if (spuCount > 0) {
            throw new BusException("该分类已关联商品");
        }
        categoryMapper.deleteById(id);
    }

    @Override
    public void updateCategory(CategoryUpdateVO categoryUpdateVO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryUpdateVO, category);
        categoryMapper.updateById(category);
    }

    @Override
    public CategoryDTO selectOneById(Long id) {
        Category category = categoryMapper.selectById(id);
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category, categoryDTO);
        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> selectListByCondition(CategorySelectVO categorySelectVO) {
        QueryWrapper<Category> queryWrapper = CategoryWrapper.queryWrapper(categorySelectVO);
        List<Category> categoryList = categoryMapper.selectList(queryWrapper);
        if (ObjectUtils.isEmpty(categoryList)) {
            return null;
        }
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDTO categoryDTO = new CategoryDTO();
            BeanUtils.copyProperties(category, categoryDTO);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

    @Override
    public ResultPage<CategoryDTO> selectPageByCondition(CategorySelectVO categorySelectVO, Integer index, Integer size) {
        Page<Category> page = new Page<>(index, size);
        QueryWrapper<Category> queryWrapper = CategoryWrapper.queryWrapper(categorySelectVO);
        Page<Category> categoryPage = categoryMapper.selectPage(page, queryWrapper);
        if (categoryPage == null || categoryPage.getRecords() == null) {
            return null;
        }
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryPage.getRecords()) {
            CategoryDTO categoryDTO = new CategoryDTO();
            BeanUtils.copyProperties(category, categoryDTO);
            categoryDTOList.add(categoryDTO);
        }
        return new ResultPage<>(categoryPage.getTotal(), categoryDTOList);
    }

    @Override
    public List<CategoryDTO> selectWithTree() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("is_show", 1);
        // 查询所有要显示的分类
        List<Category> categoryList = categoryMapper.selectByMap(map);
        if (ObjectUtils.isEmpty(categoryList)) {
            return null;
        }
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDTO categoryDTO = new CategoryDTO();
            BeanUtils.copyProperties(category, categoryDTO);
            categoryDTOList.add(categoryDTO);
        }
        // 查询所有顶级分类
        return categoryDTOList.stream()
                .filter(categoryDTO -> categoryDTO.getParentId() == 0)
                .peek(categoryDTO -> categoryDTO.setChild(getChild(categoryDTO, categoryDTOList)))
                // .sorted(Comparator.comparingInt(CategoryDTO::getSort))
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
    private List<CategoryDTO> getChild(CategoryDTO root, List<CategoryDTO> all) {
        return all.stream()
                .filter(categoryDTO -> root.getId().equals(categoryDTO.getParentId()))
                .peek(categoryDTO -> categoryDTO.setChild(getChild(categoryDTO, all)))
                // .sorted(Comparator.comparingInt(CategoryDTO::getSort))
                .sorted(Comparator.comparingInt(categoryDTO -> (categoryDTO.getSort() == null ? 0 : categoryDTO.getSort())))
                .collect(Collectors.toList());
    }

}
