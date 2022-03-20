package ajin.mall.sys.goods.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.EvaluationAddForm;
import ajin.mall.sys.goods.form.EvaluationListForm;
import ajin.mall.sys.goods.form.EvaluationUpdateForm;
import ajin.mall.sys.goods.view.EvaluationView;

/**
 * <p>
 * 商品评价表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface EvaluationService {

    /**
     * 添加商品评价
     *
     * @param evaluationAddForm 商品评价
     */
    void add(EvaluationAddForm evaluationAddForm);

    /**
     * 根据id删除商品评价
     *
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改商品评价
     *
     * @param evaluationUpdateForm 商品评价
     */
    void update(EvaluationUpdateForm evaluationUpdateForm);

    /**
     * 根据id查询商品评价
     *
     * @param id id
     * @return 商品评价
     */
    EvaluationView get(Long id);

    /**
     * 根据条件查询商品评价
     *
     * @param evaluationListForm 商品评价条件
     * @return 商品评价列表
     */
    ResultPage<EvaluationView> list(EvaluationListForm evaluationListForm);

}
