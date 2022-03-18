package cn.leemay.mall.sys.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.LabelAddForm;
import cn.leemay.mall.sys.goods.form.LabelListForm;
import cn.leemay.mall.sys.goods.form.LabelUpdateForm;
import cn.leemay.mall.sys.goods.view.LabelView;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface LabelService {

    /**
     * 添加标签
     *
     * @param labelAddForm 标签
     */
    void add(LabelAddForm labelAddForm);

    /**
     * 根据id删除标签
     *
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改标签
     *
     * @param labelUpdateForm 标签
     */
    void update(LabelUpdateForm labelUpdateForm);

    /**
     * 根据id查询标签
     *
     * @param id id
     * @return 标签
     */
    LabelView get(Long id);

    /**
     * 根据条件查询标签
     *
     * @param labelListForm 标签条件
     * @return 标签列表
     */
    ResultPage<LabelView> list(LabelListForm labelListForm);

}
