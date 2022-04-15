package ajin.mall.web.member.mapper;

import ajin.mall.common.data.entity.Favorite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 收藏映射器
 *
 * @author Ajin
 * @date 2022/04/13
 */
public interface FavoriteMapper extends BaseMapper<Favorite> {
    /**
     * 选择通过会员id和spu id
     *
     * @param memberId 成员身份
     * @param spuId    spu id
     * @return {@link Favorite}
     */
    Favorite selectByMemberIdAndSpuId(@Param("memberId") Long memberId, @Param("spuId") Long spuId);
}
