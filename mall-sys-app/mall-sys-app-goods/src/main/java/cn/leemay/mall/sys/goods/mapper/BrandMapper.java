package cn.leemay.mall.sys.goods.mapper;

import cn.leemay.mall.common.data.entity.goods.Brand;
import cn.leemay.mall.sys.goods.form.BrandListForm;
import cn.leemay.mall.sys.goods.view.BrandView;
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
     * @param brandListForm 查询条件
     * @return 品牌列表
     */
    List<BrandView> selectListByCondition(BrandListForm brandListForm);
}
