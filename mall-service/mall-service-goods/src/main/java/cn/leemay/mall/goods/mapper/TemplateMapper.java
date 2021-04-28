package cn.leemay.mall.goods.mapper;

import cn.leemay.mall.goods.entity.Template;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 规格,参数 模板表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Repository
@Mapper
public interface TemplateMapper extends BaseMapper<Template> {

}
