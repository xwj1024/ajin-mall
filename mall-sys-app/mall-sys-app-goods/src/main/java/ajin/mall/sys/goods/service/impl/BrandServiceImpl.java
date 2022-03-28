package ajin.mall.sys.goods.service.impl;

import ajin.mall.common.base.asserts.BizAssert;
import ajin.mall.common.base.page.PageHelp;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.common.data.anno.CascadeDelete;
import ajin.mall.common.data.entity.goods.Brand;
import ajin.mall.common.data.enums.TableInfo;
import ajin.mall.sys.goods.form.BrandAddForm;
import ajin.mall.sys.goods.form.BrandListForm;
import ajin.mall.sys.goods.form.BrandUpdateForm;
import ajin.mall.sys.goods.service.BrandService;
import ajin.mall.sys.goods.view.BrandView;
import ajin.mall.sys.goods.mapper.BrandMapper;
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
        BizAssert.isTrue(brandCount <= 0, "该品牌已存在");

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddForm, brand);
        int row = brandMapper.insert(brand);
        BizAssert.isTrue(row == 1, "添加失败");
    }

    @CascadeDelete(TableInfo.BRAND)
    @Override
    public void delete(Long id) {
        Brand existBrand = brandMapper.selectById(id);
        BizAssert.notNull(existBrand, "该品牌不存在");

        int row = brandMapper.deleteById(id);
        BizAssert.isTrue(row == 1, "删除失败");
    }

    @Override
    public void update(BrandUpdateForm brandUpdateForm) {
        Brand existBrand = brandMapper.selectById(brandUpdateForm.getId());
        BizAssert.notNull(existBrand, "该品牌不存在，无法修改");

        Long existBrandId = brandMapper.selectIdByName(brandUpdateForm.getName());
        BizAssert.isTrue(existBrandId == null || existBrandId.equals(brandUpdateForm.getId()), "该品牌已存在");

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandUpdateForm, brand);

        int row = brandMapper.updateById(brand);
        BizAssert.isTrue(row == 1, "修改失败");
    }

    @Override
    public BrandView get(Long id) {
        Brand brand = brandMapper.selectById(id);
        BizAssert.notNull(brand, "该品牌不存在");

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
