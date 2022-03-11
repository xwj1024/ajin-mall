package cn.leemay.mall.sys.goods.service.impl;

import cn.leemay.mall.common.base.util.ObjectUtils;
import cn.leemay.mall.common.data.entity.goods.Sku;
import cn.leemay.mall.sys.goods.mapper.SkuMapper;
import cn.leemay.mall.sys.goods.service.SkuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public void insert(Sku sku) {
        sku.setId(null);
        sku.setIsDelete(0);
        skuMapper.insert(sku);
    }

    @Override
    public void delete(Long id) {
        skuMapper.deleteById(id);
    }

    @Override
    public void update(Sku sku) {
        skuMapper.updateById(sku);
    }

    @Override
    public Sku selectOneById(Long id) {
        return skuMapper.selectById(id);
    }

    @Override
    public List<Sku> selectListByCondition(Sku sku) {
        QueryWrapper<Sku> queryWrapper = queryWrapper(sku);
        return skuMapper.selectList(queryWrapper);
    }

    @Override
    public Page<Sku> selectPageByCondition(Sku sku, Integer index, Integer size) {
        Page<Sku> page = new Page<>(index, size);
        QueryWrapper<Sku> queryWrapper = queryWrapper(sku);
        return skuMapper.selectPage(page, queryWrapper);
    }

    /**
     * 构建条件查询对象
     *
     * @param sku 条件
     * @return 对象
     */
    private QueryWrapper<Sku> queryWrapper(Sku sku) {
        QueryWrapper<Sku> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(ObjectUtils.obj2Map(sku));
        return queryWrapper;
    }

}
