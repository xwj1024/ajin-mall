package cn.leemay.mall.goods.wrapper;

import cn.leemay.mall.common.base.util.ClassUtils;
import cn.leemay.mall.common.base.util.ObjectUtils;
import cn.leemay.mall.goods.entity.Category;
import cn.leemay.mall.goods.entity.dto.CategoryDTO;
import cn.leemay.mall.goods.entity.vo.CategorySelectVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Map;


/**
 * @author Ajin
 * @since 2021-05-21
 */
public class CategoryWrapper {

    /**
     * 构建条件查询对象
     *
     * @param categorySelectVO 条件
     * @return 对象
     */
    public static QueryWrapper<Category> queryWrapper(CategorySelectVO categorySelectVO) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        Map map = ObjectUtils.obj2LineMap(categorySelectVO);
        queryWrapper.allEq(map, false);
        queryWrapper.orderByAsc("sort");
        String[] columns = ClassUtils.getColumns(CategoryDTO.class);
        queryWrapper.select(columns);
        return queryWrapper;
    }

    public static QueryWrapper<Category> queryCountWrapper(CategorySelectVO categorySelectVO) {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        Map map = ObjectUtils.obj2LineMap(categorySelectVO);
        queryWrapper.allEq(map, false);
        queryWrapper.select("id");
        return queryWrapper;
    }

}
