package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.Spec;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品规格表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-05-22
 */
@Repository
@Mapper
public interface SpecMapper extends BaseMapper<Spec> {

}
