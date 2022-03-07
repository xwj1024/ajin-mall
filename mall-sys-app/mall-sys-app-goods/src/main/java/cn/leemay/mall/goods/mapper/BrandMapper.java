package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.Brand;
import cn.leemay.mall.goods.entity.form.BrandSelectForm;
import cn.leemay.mall.goods.entity.view.BrandView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Mapper
public interface BrandMapper extends BaseMapper<Brand> {

    /**
     * 根据名称查询数量
     *
     * @param name 名称
     * @return 数量
     */
    Integer selectCountByName(@Param("name") String name);

    /**
     * 根据条件查询品牌列表
     *
     * @param brandSelectForm 查询条件
     * @return 品牌列表
     */
    List<BrandView> selectListByCondition(BrandSelectForm brandSelectForm);
}
