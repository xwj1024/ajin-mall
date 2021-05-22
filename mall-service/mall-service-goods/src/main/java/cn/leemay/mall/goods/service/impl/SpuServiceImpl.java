package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.goods.entity.Spu;
import cn.leemay.mall.goods.entity.vo.SpuSelectVO;
import cn.leemay.mall.goods.mapper.SpuMapper;
import cn.leemay.mall.goods.service.SpuService;
import cn.leemay.mall.goods.wrapper.SpuWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品spu表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Override
    public void insertSpu(Spu spu) {
        spuMapper.insert(spu);
    }

    @Override
    public void deleteSpu(Long id) {
        spuMapper.deleteById(id);
    }

    @Override
    public void updateSpu(Spu spu) {
        spuMapper.updateById(spu);
    }

    @Override
    public Spu selectOneById(Long id) {
        return spuMapper.selectById(id);
    }

    @Override
    public List<Spu> selectListByCondition(SpuSelectVO spuSelectVO) {
        QueryWrapper<Spu> queryWrapper = SpuWrapper.queryWrapper(spuSelectVO);
        return spuMapper.selectList(queryWrapper);
    }

    @Override
    public Page<Spu> selectPageByCondition(SpuSelectVO spuSelectVO, Integer index, Integer size) {
        Page<Spu> page = new Page<>(index, size);
        QueryWrapper<Spu> queryWrapper = SpuWrapper.queryWrapper(spuSelectVO);
        return spuMapper.selectPage(page, queryWrapper);
    }

}
