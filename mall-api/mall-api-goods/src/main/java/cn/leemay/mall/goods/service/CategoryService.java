package cn.leemay.mall.goods.service;

import cn.leemay.mall.goods.entity.Category;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品类目表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface CategoryService extends IService<Category> {

    /**
     * 添加分类
     *
     * @param category 分类
     */
    void insert(Category category);

    /**
     * 根据id删除分类
     *
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改分类
     *
     * @param category 分类
     */
    void update(Category category);

    /**
     * 根据条件分页查询分类
     *
     * @param category 分类条件
     * @param index    当前页
     * @param size     每页数
     * @return 分页分类
     */
    Page<Category> selectPageByCondition(Category category, Integer index, Integer size);

    /**
     * 根据条件查询分类
     *
     * @param category 分类条件
     * @return 分类列表
     */
    List<Category> selectListByCondition(Category category);

    /**
     * 树形结构查询
     *
     * @return 所有显示分类以树形结构
     */
    List<Category> selectWithTree();
}
