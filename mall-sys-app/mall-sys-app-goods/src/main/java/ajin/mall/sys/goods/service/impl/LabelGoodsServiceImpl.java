package ajin.mall.sys.goods.service.impl;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.sys.goods.form.LabelGoodsAddForm;
import ajin.mall.sys.goods.form.LabelGoodsListForm;
import ajin.mall.sys.goods.form.LabelGoodsUpdateForm;
import ajin.mall.sys.goods.service.LabelGoodsService;
import ajin.mall.sys.goods.view.LabelGoodsView;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品标签,商品 关联表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Service
public class LabelGoodsServiceImpl implements LabelGoodsService {

    @Override
    public void add(LabelGoodsAddForm labelGoodsAddForm) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(LabelGoodsUpdateForm labelGoodsUpdateForm) {

    }

    @Override
    public LabelGoodsView get(Long id) {
        return null;
    }

    @Override
    public ResultPage<LabelGoodsView> list(LabelGoodsListForm labelGoodsListForm) {
        return null;
    }
}
