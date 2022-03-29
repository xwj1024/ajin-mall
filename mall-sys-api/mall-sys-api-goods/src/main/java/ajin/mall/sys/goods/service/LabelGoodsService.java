package ajin.mall.sys.goods.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.LabelGoodsAddForm;
import ajin.mall.sys.goods.form.LabelGoodsListForm;
import ajin.mall.sys.goods.form.LabelGoodsUpdateForm;
import ajin.mall.sys.goods.view.LabelGoodsView;

/**
 * <p>
 * 商品标签,商品 关联表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface LabelGoodsService {

    /**
     * 添加商品标签,商品
     *
     * @param labelGoodsAddForm 商品标签,商品
     */
    void add(LabelGoodsAddForm labelGoodsAddForm);

    /**
     * 根据id删除商品标签,商品
     *
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改商品标签,商品
     *
     * @param labelGoodsUpdateForm 商品标签,商品
     */
    void update(LabelGoodsUpdateForm labelGoodsUpdateForm);

    /**
     * 根据id查询商品标签,商品
     *
     * @param id id
     * @return 商品标签, 商品
     */
    LabelGoodsView get(Long id);

    /**
     * 根据条件查询商品标签,商品
     *
     * @param labelGoodsListForm 商品标签,商品条件
     * @return 商品标签, 商品列表
     */
    ResultPage<LabelGoodsView> list(LabelGoodsListForm labelGoodsListForm);

}
