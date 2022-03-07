package cn.leemay.mall.sys.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.sys.goods.form.BrandInsertForm;
import cn.leemay.mall.sys.goods.form.BrandSelectForm;
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
     * @param brandInsertForm 品牌
     */
    void insertBrand(BrandInsertForm brandInsertForm);

    /**
     * 根据id删除品牌
     *
     * @param id 主键id
     */
    void deleteBrand(Long id);

    /**
     * 修改品牌
     *
     * @param brandUpdateForm 品牌
     */
    void updateBrand(BrandUpdateForm brandUpdateForm);

    /**
     * 根据id查询品牌
     *
     * @param id id
     * @return 品牌
     */
    BrandView selectOne(Long id);

    /**
     * 根据条件查询品牌
     *
     * @param brandSelectForm 品牌条件
     * @return 品牌列表
     */
    ResultPage<BrandView> selectList(BrandSelectForm brandSelectForm);

}
