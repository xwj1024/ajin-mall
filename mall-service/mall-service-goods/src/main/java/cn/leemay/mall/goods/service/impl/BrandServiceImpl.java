package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.common.base.util.ObjectUtils;
import cn.leemay.mall.goods.entity.Brand;
import cn.leemay.mall.goods.mapper.BrandMapper;
import cn.leemay.mall.goods.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void insert(Brand brand) {
        brand.setId(null);
        brandMapper.insert(brand);
    }

    @Override
    public void delete(Long id) {
        brandMapper.deleteById(id);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateById(brand);
    }

    @Override
    public Page<Brand> selectPageByCondition(Brand brand, Integer index, Integer size) {
        Page<Brand> page = new Page<>(index, size);
        QueryWrapper<Brand> queryWrapper = queryWrapper(brand);
        return brandMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Brand> selectListByCondition(Brand brand) {
        QueryWrapper<Brand> queryWrapper = queryWrapper(brand);
        return brandMapper.selectList(queryWrapper);
    }

    private QueryWrapper<Brand> queryWrapper(Brand brand) {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(ObjectUtils.obj2Map(brand));
        return queryWrapper;
    }
}
