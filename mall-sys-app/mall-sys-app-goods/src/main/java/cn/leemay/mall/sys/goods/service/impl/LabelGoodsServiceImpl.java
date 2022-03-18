package cn.leemay.mall.sys.goods.service.impl;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.LabelGoodsAddForm;
import cn.leemay.mall.sys.goods.form.LabelGoodsListForm;
import cn.leemay.mall.sys.goods.form.LabelGoodsUpdateForm;
import cn.leemay.mall.sys.goods.service.LabelGoodsService;
import cn.leemay.mall.sys.goods.view.LabelGoodsView;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签,商品 关联表 服务实现类
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
