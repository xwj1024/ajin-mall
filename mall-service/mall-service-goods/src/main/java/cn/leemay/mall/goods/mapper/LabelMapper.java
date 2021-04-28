package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.Label;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Repository
@Mapper
public interface LabelMapper extends BaseMapper<Label> {

}
