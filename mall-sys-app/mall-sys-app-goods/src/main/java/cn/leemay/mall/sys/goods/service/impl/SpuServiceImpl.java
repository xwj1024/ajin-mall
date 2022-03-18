package cn.leemay.mall.sys.goods.service.impl;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.common.data.anno.CascadeDelete;
import cn.leemay.mall.common.data.entity.goods.Spu;
import cn.leemay.mall.common.data.enums.TableInfo;
import cn.leemay.mall.sys.goods.form.SpuAddForm;
import cn.leemay.mall.sys.goods.form.SpuListForm;
import cn.leemay.mall.sys.goods.form.SpuUpdateForm;
import cn.leemay.mall.sys.goods.mapper.SkuMapper;
import cn.leemay.mall.sys.goods.mapper.SpuMapper;
import cn.leemay.mall.sys.goods.service.SpuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
public class SpuServiceImpl implements SpuService {

    @Resource
    private SpuMapper spuMapper;

    @Resource
    private SkuMapper skuMapper;

    @Override
    public void add(SpuAddForm spuAddForm) {
        Spu spu = new Spu();
        BeanUtils.copyProperties(spuAddForm, spu);
        spuMapper.insert(spu);
    }

    @CascadeDelete(TableInfo.SPU)
    @Override
    public void delete(Long id) {
        spuMapper.deleteById(id);
        Map<String, Object> map = new HashMap<>(1);
        map.put("spu_id", id);
        skuMapper.deleteByMap(map);
    }

    @Override
    public void update(SpuUpdateForm spuUpdateForm) {
    }

    @Override
    public Spu get(Long id) {
        return spuMapper.selectById(id);
    }

    @Override
    public ResultPage<Spu> list(SpuListForm spuListForm) {
        return null;
    }

}
