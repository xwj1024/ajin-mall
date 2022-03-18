package cn.leemay.mall.sys.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.LabelGoodsAddForm;
import cn.leemay.mall.sys.goods.form.LabelGoodsListForm;
import cn.leemay.mall.sys.goods.form.LabelGoodsUpdateForm;
import cn.leemay.mall.sys.goods.view.LabelGoodsView;

/**
 * <p>
 * 标签,商品 关联表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface LabelGoodsService {

    /**
     * 添加标签,商品
     *
     * @param labelGoodsAddForm 标签,商品
     */
    void add(LabelGoodsAddForm labelGoodsAddForm);

    /**
     * 根据id删除标签,商品
     *
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改标签,商品
     *
     * @param labelGoodsUpdateForm 标签,商品
     */
    void update(LabelGoodsUpdateForm labelGoodsUpdateForm);

    /**
     * 根据id查询标签,商品
     *
     * @param id id
     * @return 标签, 商品
     */
    LabelGoodsView get(Long id);

    /**
     * 根据条件查询标签,商品
     *
     * @param labelGoodsListForm 标签,商品条件
     * @return 标签, 商品列表
     */
    ResultPage<LabelGoodsView> list(LabelGoodsListForm labelGoodsListForm);

}
