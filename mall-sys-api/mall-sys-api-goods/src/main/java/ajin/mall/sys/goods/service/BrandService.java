package ajin.mall.sys.goods.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.BrandAddForm;
import ajin.mall.sys.goods.form.BrandListForm;
import ajin.mall.sys.goods.form.BrandUpdateForm;
import ajin.mall.sys.goods.view.BrandView;

/**
 * <p>
 * 商品品牌表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface BrandService {

    /**
     * 添加商品品牌
     *
     * @param brandAddForm 商品品牌
     */
    void add(BrandAddForm brandAddForm);

    /**
     * 根据id删除商品品牌
     *
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改商品品牌
     *
     * @param brandUpdateForm 商品品牌
     */
    void update(BrandUpdateForm brandUpdateForm);

    /**
     * 根据id查询商品品牌
     *
     * @param id id
     * @return 商品品牌
     */
    BrandView get(Long id);

    /**
     * 根据条件查询商品品牌
     *
     * @param brandListForm 商品品牌条件
     * @return 商品品牌列表
     */
    ResultPage<BrandView> list(BrandListForm brandListForm);

}
