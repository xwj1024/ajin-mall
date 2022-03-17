package cn.leemay.mall.sys.goods.service.impl;

import cn.leemay.mall.common.base.asserts.BizAssert;
import cn.leemay.mall.common.base.page.PageHelp;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.common.data.anno.CascadeDelete;
import cn.leemay.mall.common.data.entity.goods.Brand;
import cn.leemay.mall.common.data.enums.TableInfo;
import cn.leemay.mall.sys.goods.form.BrandAddForm;
import cn.leemay.mall.sys.goods.form.BrandGetForm;
import cn.leemay.mall.sys.goods.form.BrandUpdateForm;
import cn.leemay.mall.sys.goods.mapper.BrandMapper;
import cn.leemay.mall.sys.goods.mapper.SpuMapper;
import cn.leemay.mall.sys.goods.service.BrandService;
import cn.leemay.mall.sys.goods.view.BrandView;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Resource
    private SpuMapper spuMapper;

    @Override
    public void addBrand(BrandAddForm brandAddForm) {

        Integer brandCount = brandMapper.selectCountByName(brandAddForm.getName());
        BizAssert.isTrue(brandCount <= 0, "已有该品牌");

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddForm, brand);
        int row = brandMapper.insert(brand);
        BizAssert.isTrue(row == 1, "添加失败");
    }

    @CascadeDelete(TableInfo.BRAND)
    @Override
    public void deleteBrand(Long id) {
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
    public ResultPage<BrandView> selectList(BrandGetForm brandGetForm) {
        PageHelp.startPage(brandGetForm.getPageIndex(), brandGetForm.getPageSize());
        List<BrandView> list = brandMapper.selectListByCondition(brandGetForm);
        return new ResultPage<>(new PageInfo<>(list));
    }
}
