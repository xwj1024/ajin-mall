package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.common.base.exception.BusException;
import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.Brand;
import cn.leemay.mall.goods.entity.Spu;
import cn.leemay.mall.goods.entity.dto.BrandDTO;
import cn.leemay.mall.goods.entity.vo.BrandInsertVO;
import cn.leemay.mall.goods.entity.vo.BrandSelectVO;
import cn.leemay.mall.goods.entity.vo.BrandUpdateVO;
import cn.leemay.mall.goods.entity.vo.SpuSelectVO;
import cn.leemay.mall.goods.mapper.BrandMapper;
import cn.leemay.mall.goods.mapper.SpuMapper;
import cn.leemay.mall.goods.service.BrandService;
import cn.leemay.mall.goods.wrapper.BrandWrapper;
import cn.leemay.mall.goods.wrapper.SpuWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
@org.apache.dubbo.config.annotation.Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public void insertBrand(BrandInsertVO brandInsertVO) {
        BrandSelectVO brandSelectVO = new BrandSelectVO();
        brandSelectVO.setName(brandInsertVO.getName());
        Integer brandCount = brandMapper.selectCount(BrandWrapper.queryCountWrapper(brandSelectVO));
        if (brandCount > 0) {
            throw new BusException("已有该品牌");
        }
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandInsertVO, brand);
        brandMapper.insert(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        SpuSelectVO spuSelectVO = new SpuSelectVO();
        spuSelectVO.setBrandId(id);
        Integer spuCount = spuMapper.selectCount(SpuWrapper.queryCountWrapper(spuSelectVO));
        if (spuCount > 0) {
            throw new BusException("该品牌已关联商品");
        }
        brandMapper.deleteById(id);
    }

    @Override
    public void updateBrand(BrandUpdateVO brandUpdateVO) {
        BrandSelectVO brandSelectVO = new BrandSelectVO();
        brandSelectVO.setName(brandUpdateVO.getName());
        Integer brandCount = brandMapper.selectCount(BrandWrapper.queryCountWrapper(brandSelectVO));
        if (brandCount > 0) {
            throw new BusException("已有该品牌");
        }
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandUpdateVO, brand);
        brandMapper.updateById(brand);
    }

    @Override
    public BrandDTO selectOneById(Long id) {
        Brand brand = brandMapper.selectById(id);
        BrandDTO brandDTO = new BrandDTO();
        BeanUtils.copyProperties(brand, brandDTO);
        return brandDTO;
    }

    @Override
    public List<BrandDTO> selectListByCondition(BrandSelectVO brandSelectVO) {
        QueryWrapper<Brand> queryWrapper = BrandWrapper.queryWrapper(brandSelectVO);
        List<Brand> brandList = brandMapper.selectList(queryWrapper);
        if (brandList == null || brandList.size() <= 0) {
            return null;
        }
        List<BrandDTO> brandDTOList = new ArrayList<>();
        for (Brand brand : brandList) {
            BrandDTO brandDTO = new BrandDTO();
            BeanUtils.copyProperties(brand, brandDTO);
            brandDTOList.add(brandDTO);
        }
        return brandDTOList;
    }

    @Override
    public ResultPage<BrandDTO> selectPageByCondition(BrandSelectVO brandSelectVO, Integer index, Integer size) {
        Page<Brand> page = new Page<>(index, size);
        QueryWrapper<Brand> queryWrapper = BrandWrapper.queryWrapper(brandSelectVO);
        Page<Brand> brandPage = brandMapper.selectPage(page, queryWrapper);
        if (brandPage == null || brandPage.getRecords() == null) {
            return null;
        }
        List<BrandDTO> brandDTOList = new ArrayList<>();
        for (Brand brand : brandPage.getRecords()) {
            BrandDTO brandDTO = new BrandDTO();
            BeanUtils.copyProperties(brand, brandDTO);
            brandDTOList.add(brandDTO);
        }
        ResultPage<BrandDTO> resultPage = new ResultPage<>(brandPage.getTotal(), brandDTOList);
        resultPage.setTotal(brandPage.getTotal());
        resultPage.setData(brandDTOList);
        return resultPage;
    }

}
