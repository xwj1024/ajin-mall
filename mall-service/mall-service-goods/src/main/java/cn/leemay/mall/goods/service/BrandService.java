package cn.leemay.mall.goods.service;

import cn.leemay.mall.goods.entity.Brand;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface BrandService extends IService<Brand> {

    /**
     * 添加品牌
     *
     * @param brand 品牌
     */
    void insert(Brand brand);

    /**
     * 根据id删除品牌
     *
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改品牌
     *
     * @param brand 品牌
     */
    void update(Brand brand);

    /**
     * 根据条件分页查询品牌
     *
     * @param brand 品牌条件
     * @param index 当前页
     * @param size  每页数
     * @return 分页品牌
     */
    Page<Brand> selectPageByCondition(Brand brand, Integer index, Integer size);

    /**
     * 根据条件查询品牌
     *
     * @param brand 品牌条件
     * @return 品牌列表
     */
    List<Brand> selectListByCondition(Brand brand);
}
