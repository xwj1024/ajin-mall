package ajin.mall.web.member.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.web.member.form.FavoriteListForm;
import ajin.mall.web.member.form.FavoriteChooseForm;
import ajin.mall.web.member.view.FavoriteView;

/**
 * 收藏服务
 *
 * @author Ajin
 * @date 2022/04/13
 */
public interface FavoriteService {


    /**
     * 选择
     *
     * @param favoriteChooseForm 最喜欢选择形式
     * @return {@link Boolean}
     */
    Boolean choose(FavoriteChooseForm favoriteChooseForm);

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
