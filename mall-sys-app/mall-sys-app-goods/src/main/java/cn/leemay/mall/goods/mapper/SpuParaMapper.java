package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.SpuPara;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品，参数 关联表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Mapper
public interface SpuParaMapper extends BaseMapper<SpuPara> {

}
