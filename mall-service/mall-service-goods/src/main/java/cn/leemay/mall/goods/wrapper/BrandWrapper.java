package cn.leemay.mall.goods.wrapper;

import cn.leemay.mall.common.base.util.ClassUtils;
import cn.leemay.mall.common.base.util.ObjectUtils;
import cn.leemay.mall.goods.entity.Brand;
import cn.leemay.mall.goods.entity.dto.BrandDTO;
import cn.leemay.mall.goods.entity.vo.BrandSelectVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Map;

/**
 * @author Ajin
 * @since 2021-05-21
 */
public class BrandWrapper {

    /**
     * 构建条件查询对象
     *
     * @param brandSelectVO 条件
     * @return 对象
     */
    public static QueryWrapper<Brand> queryWrapper(BrandSelectVO brandSelectVO) {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(ObjectUtils.obj2Map(brandSelectVO));
        queryWrapper.orderByAsc("sort");
        String[] columns = ClassUtils.getColumns(BrandDTO.class);
        queryWrapper.select(columns);
        return queryWrapper;
    }

    public static QueryWrapper<Brand> queryCountWrapper(BrandSelectVO brandSelectVO) {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        Map map = ObjectUtils.obj2LineMap(brandSelectVO);
        queryWrapper.allEq(map, false);
        queryWrapper.select("id");
        return queryWrapper;
    }
}
