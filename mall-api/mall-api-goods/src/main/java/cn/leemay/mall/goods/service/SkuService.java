package cn.leemay.mall.goods.service;

import cn.leemay.mall.goods.entity.Sku;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品sku表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface SkuService extends IService<Sku> {
    /**
     * 添加sku
     *
     * @param sku sku
     */
    void insert(Sku sku);

    /**
     * 根据id删除sku
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 修改sku
     *
     * @param sku sku
     */
    void update(Sku sku);

    /**
     * 根据id查询sku
     *
     * @param id id
     * @return sku
     */
    Sku selectOneById(Long id);

    /**
     * 根据条件查询sku
     *
     * @param sku sku
     * @return sku列表
     */
    List<Sku> selectListByCondition(Sku sku);

    /**
     * 根据条件分页查询sku
     *
     * @param sku   sku
     * @param index 当前页码
     * @param size  每页条数
     * @return sku分页数据
     */
    Page<Sku> selectPageByCondition(Sku sku, Integer index, Integer size);
}
