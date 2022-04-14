package ajin.mall.web.member.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.web.member.form.BrowseListForm;
import ajin.mall.web.member.view.BrowseView;

/**
 * 浏览服务
 *
 * @author Ajin
 * @date 2022/04/14
 */
public interface BrowseService {
    /**
     * 删除
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 列表
     *
     * @param browseListForm 浏览列表形式
     * @return {@link ResultPage}<{@link BrowseView}>
     */
    ResultPage<BrowseView> list(BrowseListForm browseListForm);

}
