package ajin.mall.sys.goods.service.impl;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.LabelAddForm;
import ajin.mall.sys.goods.form.LabelListForm;
import ajin.mall.sys.goods.form.LabelUpdateForm;
import ajin.mall.sys.goods.service.LabelService;
import ajin.mall.sys.goods.view.LabelView;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品标签表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Override
    public void add(LabelAddForm labelAddForm) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(LabelUpdateForm labelUpdateForm) {

    }

    @Override
    public LabelView get(Long id) {
        return null;
    }

    @Override
    public ResultPage<LabelView> list(LabelListForm labelListForm) {
        return null;
    }
}
