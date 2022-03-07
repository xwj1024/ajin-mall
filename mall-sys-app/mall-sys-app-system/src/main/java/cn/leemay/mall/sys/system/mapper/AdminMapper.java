package cn.leemay.mall.sys.system.mapper;

import cn.leemay.mall.common.data.entity.system.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
@Repository
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
