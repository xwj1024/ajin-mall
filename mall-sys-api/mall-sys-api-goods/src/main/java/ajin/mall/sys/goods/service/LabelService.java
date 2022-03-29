package ajin.mall.sys.goods.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.LabelAddForm;
import ajin.mall.sys.goods.form.LabelListForm;
import ajin.mall.sys.goods.form.LabelUpdateForm;
import ajin.mall.sys.goods.view.LabelView;

/**
 * <p>
 * 商品标签表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface LabelService {

    /**
     * 添加商品标签
     *
     * @param labelAddForm 商品标签
     */
    void add(LabelAddForm labelAddForm);

    /**
     * 根据id删除商品标签
     *
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改商品标签
     *
     * @param labelUpdateForm 商品标签
     */
    void update(LabelUpdateForm labelUpdateForm);

    /**
     * 根据id查询商品标签
     *
     * @param id id
     * @return 商品标签
     */
    LabelView get(Long id);

    /**
     * 根据条件查询商品标签
     *
     * @param labelListForm 商品标签条件
     * @return 商品标签列表
     */
    ResultPage<LabelView> list(LabelListForm labelListForm);

}
