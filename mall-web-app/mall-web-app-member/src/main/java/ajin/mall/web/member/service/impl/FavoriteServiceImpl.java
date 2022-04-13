package ajin.mall.web.member.service.impl;

import ajin.mall.common.base.asserts.BizAssert;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.common.data.entity.Favorite;
import ajin.mall.web.member.form.FavoriteOnOrOffForm;
import ajin.mall.web.member.form.FavoriteListForm;
import ajin.mall.web.member.mapper.FavoriteMapper;
import ajin.mall.web.member.service.FavoriteService;
import ajin.mall.web.member.view.FavoriteView;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 最喜欢服务impl
 *
 * @author Ajin
 * @date 2022/04/13
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Resource
    private FavoriteMapper favoriteMapper;

    @Override
    public Boolean onOrOff(FavoriteOnOrOffForm favoriteOnOrOffForm) {
        // 判断该商品是否已收藏
        Favorite existFavorite = favoriteMapper.selectByMemberIdAndSpuId(favoriteOnOrOffForm.getMemberId(), favoriteOnOrOffForm.getSpuId());
        if (existFavorite != null) {
            // 如果已经收藏，则取消收藏
            int affectRow = favoriteMapper.deleteById(existFavorite.getId());
            BizAssert.isTrue(affectRow == 1, "取消失败");
            return false;
        }
        // 没有收藏，添加收藏
        Favorite favorite = new Favorite();
        BeanUtils.copyProperties(favoriteOnOrOffForm, favorite);
        favorite.setFavoriteTime(LocalDateTime.now());

        int affectRow = favoriteMapper.insert(favorite);
        BizAssert.isTrue(affectRow == 1, "收藏失败");
        return true;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ResultPage<FavoriteView> list(FavoriteListForm favoriteListForm) {
        return null;
    }
}
