package ajin.mall.sys.member.mapper;

import ajin.mall.common.data.entity.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 地址映射器
 *
 * @author Ajin
 * @date 2022/04/13
 */
public interface AddressMapper extends BaseMapper<Address> {

    /**
     * 更新是否默认由成员id
     *
     * @param memberId  成员身份
     * @param isDefault 是否默认
     */
    void updateIsDefaultByMemberId(@Param("memberId") Long memberId, @Param("isDefault") Integer isDefault);
}
