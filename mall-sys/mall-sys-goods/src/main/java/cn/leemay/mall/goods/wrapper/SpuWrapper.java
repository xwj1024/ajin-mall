package cn.leemay.mall.goods.wrapper;

import cn.leemay.mall.common.base.util.ClassUtils;
import cn.leemay.mall.common.base.util.ObjectUtils;
import cn.leemay.mall.goods.entity.Spu;
import cn.leemay.mall.goods.entity.view.SpuDTO;
import cn.leemay.mall.goods.entity.form.SpuSelectVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Map;


/**
 * @author Ajin
 * @since 2021-05-21
 */
public class SpuWrapper {

    /**
     * 构建条件查询对象
     *
     * @param spuSelectVO 条件
     * @return 对象
     */
    public static QueryWrapper<Spu> queryWrapper(SpuSelectVO spuSelectVO) {
        QueryWrapper<Spu> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(ObjectUtils.obj2Map(spuSelectVO));
        String[] columns = ClassUtils.getColumns(SpuDTO.class);
        queryWrapper.select(columns);
        return queryWrapper;
    }

    public static QueryWrapper<Spu> queryCountWrapper(SpuSelectVO spuSelectVO) {
        QueryWrapper<Spu> queryWrapper = new QueryWrapper<>();
        Map map = ObjectUtils.obj2LineMap(spuSelectVO);
        queryWrapper.allEq(map, false);
        queryWrapper.select("id");
        return queryWrapper;
    }
}
