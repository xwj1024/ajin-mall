package ajin.mall.sys.goods.service.impl;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.EvaluationAddForm;
import ajin.mall.sys.goods.form.EvaluationListForm;
import ajin.mall.sys.goods.form.EvaluationUpdateForm;
import ajin.mall.sys.goods.service.EvaluationService;
import ajin.mall.sys.goods.view.EvaluationView;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Override
    public void add(EvaluationAddForm evaluationAddForm) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(EvaluationUpdateForm evaluationUpdateForm) {

    }

    @Override
    public EvaluationView get(Long id) {
        return null;
    }

    @Override
    public ResultPage<EvaluationView> list(EvaluationListForm evaluationListForm) {
        return null;
    }
}
