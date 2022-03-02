package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.common.base.asserts.BizAssert;
import cn.leemay.mall.common.base.exception.BizException;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.Brand;
import cn.leemay.mall.goods.entity.view.BrandView;
import cn.leemay.mall.goods.entity.form.BrandInsertForm;
import cn.leemay.mall.goods.entity.form.BrandSelectForm;
import cn.leemay.mall.goods.entity.form.BrandUpdateForm;
import cn.leemay.mall.goods.entity.form.SpuSelectForm;
import cn.leemay.mall.goods.mapper.BrandMapper;
import cn.leemay.mall.goods.mapper.SpuMapper;
import cn.leemay.mall.goods.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        SpuSelectForm spuSelectForm = new SpuSelectForm();
        spuSelectForm.setBrandId(id);
//        Integer spuCount = spuMapper.selectCount(SpuWrapper.queryCountWrapper(spuSelectForm));
//        if (spuCount > 0) {
//            throw new BizException("该品牌已关联商品");
//        }
        brandMapper.deleteById(id);
    }

    @Override
    public void updateBrand(BrandUpdateForm brandUpdateForm) {
        BrandSelectForm brandSelectForm = new BrandSelectForm();
        brandSelectForm.setName(brandUpdateForm.getName());
//        Integer brandCount = brandMapper.selectCount(BrandWrapper.queryCountWrapper(brandSelectForm));
//        if (brandCount > 0) {
//            throw new BizException("已有该品牌");
//        }
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandUpdateForm, brand);
        brandMapper.updateById(brand);
    }

    @Override
    public BrandView selectOneById(Long id) {
        log.error("日志！！@@##");
        Brand     brand     = brandMapper.selectById(id);
        BrandView brandView = new BrandView();
        BeanUtils.copyProperties(brand, brandView);
        return brandView;
    }

    @Override
    public List<BrandView> selectListByCondition(BrandSelectForm brandSelectForm) {
//        QueryWrapper<Brand> queryWrapper = BrandWrapper.queryWrapper(brandSelectForm);
//        List<Brand>         brandList    = brandMapper.selectList(queryWrapper);
//        if (ObjectUtils.isEmpty(brandList)) {
//            return null;
//        }
//        List<BrandView> brandViewList = new ArrayList<>();
//        for (Brand brand : brandList) {
//            BrandView brandView = new BrandView();
//            BeanUtils.copyProperties(brand, brandView);
//            brandViewList.add(brandView);
//        }
//        return brandViewList;
        return null;
    }

    @Override
    public ResultPage<BrandView> selectPageByCondition(BrandSelectForm brandSelectForm, Integer index, Integer size) {
//        Page<Brand>         page         = new Page<>(index, size);
//        QueryWrapper<Brand> queryWrapper = BrandWrapper.queryWrapper(brandSelectForm);
//        Page<Brand>         brandPage    = brandMapper.selectPage(page, queryWrapper);
//        if (brandPage == null || brandPage.getRecords() == null) {
//            return null;
//        }
//        List<BrandView> brandViewList = new ArrayList<>();
//        for (Brand brand : brandPage.getRecords()) {
//            BrandView brandView = new BrandView();
//            BeanUtils.copyProperties(brand, brandView);
//            brandViewList.add(brandView);
//        }
//        return new ResultPage<>(brandPage.getTotal(), brandViewList);
        return null;
    }

}
