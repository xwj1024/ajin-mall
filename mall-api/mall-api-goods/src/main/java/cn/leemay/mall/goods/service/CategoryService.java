package cn.leemay.mall.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.Category;
import cn.leemay.mall.goods.entity.dto.CategoryDTO;
import cn.leemay.mall.goods.entity.vo.CategoryInsertVO;
import cn.leemay.mall.goods.entity.vo.CategorySelectVO;
import cn.leemay.mall.goods.entity.vo.CategoryUpdateVO;
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
     * @param categoryInsertVO 分类
     */
    void insertCategory(CategoryInsertVO categoryInsertVO);

    /**
     * 根据id删除分类
     *
     * @param id 主键id
     */
    void deleteCategory(Long id);

    /**
     * 修改分类
     *
     * @param categoryUpdateVO 分类
     */
    void updateCategory(CategoryUpdateVO categoryUpdateVO);

    /**
     * 根据id查询分类
     *
     * @param id id
     * @return 分类
     */
    CategoryDTO selectOneById(Long id);

    /**
     * 根据条件查询分类
     *
     * @param categorySelectVO 分类条件
     * @return 分类列表
     */
    List<CategoryDTO> selectListByCondition(CategorySelectVO categorySelectVO);

    /**
     * 根据条件分页查询分类
     *
     * @param categorySelectVO 分类条件
     * @param index    当前页
     * @param size     每页数
     * @return 分页分类
     */
    ResultPage<CategoryDTO> selectPageByCondition(CategorySelectVO categorySelectVO, Integer index, Integer size);

    /**
     * 树形结构查询
     *
     * @return 所有显示分类以树形结构
     */
    List<CategoryDTO> selectWithTree();
}
