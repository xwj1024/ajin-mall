package cn.leemay.mall.sys.goods.service.impl;

import cn.leemay.mall.common.base.asserts.BizAssert;
import cn.leemay.mall.common.base.page.PageHelp;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.common.data.entity.goods.Sku;
import cn.leemay.mall.sys.goods.form.SkuAddForm;
import cn.leemay.mall.sys.goods.form.SkuListForm;
import cn.leemay.mall.sys.goods.form.SkuUpdateForm;
import cn.leemay.mall.sys.goods.mapper.SkuMapper;
import cn.leemay.mall.sys.goods.service.SkuService;
import cn.leemay.mall.sys.goods.view.SkuView;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品sku表 服务实现类
 * </p>
 * d
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Service
@org.apache.dubbo.config.annotation.Service
public class SkuServiceImpl implements SkuService {

    @Resource
    private SkuMapper skuMapper;

    @Override
    public void add(SkuAddForm skuAddForm) {
        Sku sku = new Sku();
        BeanUtils.copyProperties(skuAddForm, sku);

        int row = skuMapper.insert(sku);
        BizAssert.isTrue(row == 1, "添加失败");
    }

    @Override
    public void delete(Long id) {
        skuMapper.deleteById(id);
    }

    @Override
    public void update(SkuUpdateForm skuUpdateForm) {
        Sku sku = new Sku();
        BeanUtils.copyProperties(skuUpdateForm, sku);
        skuMapper.updateById(sku);
    }

    @Override
    public Sku get(Long id) {
        return skuMapper.selectById(id);
    }

    @Override
    public ResultPage<SkuView> list(SkuListForm skuListForm) {
        PageHelp.startPage(skuListForm.getPageIndex(), skuListForm.getPageSize());
        List<SkuView> list = skuMapper.selectListByCondition(skuListForm);
        return new ResultPage<>(new PageInfo<>(list));
    }

}
