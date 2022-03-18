package cn.leemay.mall.sys.goods.service.impl;

import cn.leemay.mall.common.base.asserts.BizAssert;
import cn.leemay.mall.common.base.page.PageHelp;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.common.data.anno.CascadeDelete;
import cn.leemay.mall.common.data.entity.goods.Brand;
import cn.leemay.mall.common.data.enums.TableInfo;
import cn.leemay.mall.sys.goods.form.BrandAddForm;
import cn.leemay.mall.sys.goods.form.BrandListForm;
import cn.leemay.mall.sys.goods.form.BrandUpdateForm;
import cn.leemay.mall.sys.goods.mapper.BrandMapper;
import cn.leemay.mall.sys.goods.service.BrandService;
import cn.leemay.mall.sys.goods.view.BrandView;
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

    @Override
    public void add(BrandAddForm brandAddForm) {
        Integer brandCount = brandMapper.selectCountByName(brandAddForm.getName());
        BizAssert.isTrue(brandCount <= 0, "已有该品牌");

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddForm, brand);
        int row = brandMapper.insert(brand);
        BizAssert.isTrue(row == 1, "添加失败");
    }

    @CascadeDelete(TableInfo.BRAND)
    @Override
    public void delete(Long id) {
        Brand existBrand = brandMapper.selectById(id);
//        BizAssert.notNull(existBrand, "没有该品牌");

        int row = brandMapper.deleteById(id);
        BizAssert.isTrue(row == 1, "删除失败");
    }

    @Override
    public void update(BrandUpdateForm brandUpdateForm) {
        Brand existBrand = brandMapper.selectById(brandUpdateForm.getId());
        BizAssert.notNull(existBrand, "没有该品牌");

        Integer brandCount = brandMapper.selectCountByName(brandUpdateForm.getName());
        BizAssert.isTrue(brandCount <= 0, "已有该品牌");

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandUpdateForm, brand);

        int row = brandMapper.updateById(brand);
        BizAssert.isTrue(row == 1, "修改失败");
    }

    @Override
    public BrandView get(Long id) {
        Brand     brand     = brandMapper.selectById(id);
        BrandView brandView = new BrandView();
        BeanUtils.copyProperties(brand, brandView);
        return brandView;
    }

    @Override
    public ResultPage<BrandView> list(BrandListForm brandListForm) {
        PageHelp.startPage(brandListForm.getPageIndex(), brandListForm.getPageSize());
        List<BrandView> list = brandMapper.selectListByCondition(brandListForm);
        return new ResultPage<>(new PageInfo<>(list));
    }
}
