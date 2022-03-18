package cn.leemay.mall.sys.goods.service.impl;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.LabelAddForm;
import cn.leemay.mall.sys.goods.form.LabelListForm;
import cn.leemay.mall.sys.goods.form.LabelUpdateForm;
import cn.leemay.mall.sys.goods.service.LabelService;
import cn.leemay.mall.sys.goods.view.LabelView;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
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
