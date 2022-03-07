package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.common.base.asserts.BizAssert;
import cn.leemay.mall.common.base.page.PageHelp;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.Brand;
import cn.leemay.mall.goods.entity.form.BrandInsertForm;
import cn.leemay.mall.goods.entity.form.BrandSelectForm;
import cn.leemay.mall.goods.entity.form.BrandUpdateForm;
import cn.leemay.mall.goods.entity.view.BrandView;
import cn.leemay.mall.goods.mapper.BrandMapper;
import cn.leemay.mall.goods.mapper.SpuMapper;
import cn.leemay.mall.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Slf4j
@Service
@org.apache.dubbo.config.annotation.Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Resource
    private SpuMapper spuMapper;

    @Override
    public void insertBrand(BrandInsertForm brandInsertForm) {
        Integer brandCount = brandMapper.selectCountByName(brandInsertForm.getName());
        BizAssert.isTrue(brandCount <= 0, "已有该品牌");

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandInsertForm, brand);
        int row = brandMapper.insert(brand);
        BizAssert.isTrue(row == 1, "添加失败");
    }

    @Override
    public void deleteBrand(Long id) {
        Integer spuCount = spuMapper.selectCountByBrandId(id);
        BizAssert.isTrue(spuCount <= 0, "该品牌已关联商品，无法删除");

        int row = brandMapper.deleteById(id);
        BizAssert.isTrue(row == 1, "删除失败");
    }

    @Override
    public void updateBrand(BrandUpdateForm brandUpdateForm) {
        Integer brandCount = brandMapper.selectCountByName(brandUpdateForm.getName());
        BizAssert.isTrue(brandCount <= 0, "已有该品牌");

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandUpdateForm, brand);

        int row = brandMapper.updateById(brand);
        BizAssert.isTrue(row == 1, "修改失败");
    }

    @Override
    public BrandView selectOne(Long id) {
        Brand     brand     = brandMapper.selectById(id);
        BrandView brandView = new BrandView();
        BeanUtils.copyProperties(brand, brandView);
        return brandView;
    }

    @Override
    public ResultPage<BrandView> selectList(BrandSelectForm brandSelectForm) {
        PageHelp.startPage(brandSelectForm.getPageIndex(), brandSelectForm.getPageSize());
        List<BrandView> list = brandMapper.selectListByCondition(brandSelectForm);
        return new ResultPage<>(new PageInfo<>(list));
    }
}
