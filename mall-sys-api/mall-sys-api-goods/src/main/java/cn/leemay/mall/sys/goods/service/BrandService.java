package cn.leemay.mall.sys.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.BrandAddForm;
import cn.leemay.mall.sys.goods.form.BrandListForm;
import cn.leemay.mall.sys.goods.form.BrandUpdateForm;
import cn.leemay.mall.sys.goods.view.BrandView;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface BrandService {

    /**
     * 添加品牌
     *
     * @param brandAddForm 品牌
     */
    void add(BrandAddForm brandAddForm);

    /**
     * 根据id删除品牌
     *
     * @param id 主键id
     */
    void delete(Long id);

    /**
     * 修改品牌
     *
     * @param brandUpdateForm 品牌
     */
    void update(BrandUpdateForm brandUpdateForm);

    /**
     * 根据id查询品牌
     *
     * @param id id
     * @return 品牌
     */
    BrandView get(Long id);

    /**
     * 根据条件查询品牌
     *
     * @param brandListForm 品牌条件
     * @return 品牌列表
     */
    ResultPage<BrandView> list(BrandListForm brandListForm);

}
