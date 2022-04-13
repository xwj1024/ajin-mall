package ajin.mall.web.member.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.web.member.form.FavoriteListForm;
import ajin.mall.web.member.form.FavoriteOnOrOffForm;
import ajin.mall.web.member.view.FavoriteView;

/**
 * 收藏服务
 *
 * @author Ajin
 * @date 2022/04/13
 */
public interface FavoriteService {

    /**
     * 打开或关闭
     *
     * @param favoriteOnOrOffForm 最喜欢打开或关闭表单
     * @return {@link Boolean}
     */
    Boolean onOrOff(FavoriteOnOrOffForm favoriteOnOrOffForm);

    /**
     * 删除
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 列表
     *
     * @param favoriteListForm 最喜欢列表形式
     * @return {@link ResultPage}<{@link FavoriteView}>
     */
    ResultPage<FavoriteView> list(FavoriteListForm favoriteListForm);

}
