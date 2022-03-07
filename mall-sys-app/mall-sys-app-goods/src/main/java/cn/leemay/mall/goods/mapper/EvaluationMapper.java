package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.Evaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品评价表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Mapper
public interface EvaluationMapper extends BaseMapper<Evaluation> {

}
