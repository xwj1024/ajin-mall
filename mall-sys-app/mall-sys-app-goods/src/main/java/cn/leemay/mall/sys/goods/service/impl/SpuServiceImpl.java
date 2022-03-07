package cn.leemay.mall.sys.goods.service.impl;

import cn.leemay.mall.sys.goods.form.SpuInsertForm;
import cn.leemay.mall.sys.goods.form.SpuSelectForm;
import cn.leemay.mall.sys.goods.mapper.SkuMapper;
import cn.leemay.mall.sys.goods.mapper.SpuMapper;
import cn.leemay.mall.sys.goods.service.SpuService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public void insertSpu(SpuInsertForm spuInsertForm) {
        Spu spu = new Spu();
        BeanUtils.copyProperties(spuInsertForm, spu);
        spuMapper.insert(spu);
    }

    @Override
    public void deleteSpu(Long id) {
        spuMapper.deleteById(id);
        Map<String, Object> map = new HashMap<>(1);
        map.put("spu_id", id);
        skuMapper.deleteByMap(map);
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
    public List<Spu> selectListByCondition(SpuSelectForm spuSelectForm) {
//        QueryWrapper<Spu> queryWrapper = SpuWrapper.queryWrapper(spuSelectForm);
//        return spuMapper.selectList(queryWrapper);
        return null;
    }

    @Override
    public Page<Spu> selectPageByCondition(SpuSelectForm spuSelectForm, Integer index, Integer size) {
        Page<Spu> page = new Page<>(index, size);
//        QueryWrapper<Spu> queryWrapper = SpuWrapper.queryWrapper(spuSelectForm);
//        return spuMapper.selectPage(page, queryWrapper);
        return null;
    }

}
