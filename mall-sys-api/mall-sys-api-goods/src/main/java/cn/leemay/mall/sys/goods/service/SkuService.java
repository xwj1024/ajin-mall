package cn.leemay.mall.sys.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.common.data.entity.goods.Sku;
import cn.leemay.mall.sys.goods.form.SkuAddForm;
import cn.leemay.mall.sys.goods.form.SkuListForm;
import cn.leemay.mall.sys.goods.form.SkuUpdateForm;
import cn.leemay.mall.sys.goods.view.SkuView;

/**
 * <p>
 * 商品sku表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface SkuService {

    /**
     * 添加sku
     *
     * @param skuAddForm sku添加对象
     */
    void add(SkuAddForm skuAddForm);

    /**
     * 根据id删除sku
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 修改sku
     *
     * @param skuUpdateForm sku修改对象
     */
    void update(SkuUpdateForm skuUpdateForm);

    /**
     * 根据id查询sku
     *
     * @param id id
     * @return sku
     */
    Sku get(Long id);

    /**
     * 根据条件查询sku
     *
     * @param skuListForm sku
     * @return sku列表
     */
    ResultPage<SkuView> list(SkuListForm skuListForm);
}
