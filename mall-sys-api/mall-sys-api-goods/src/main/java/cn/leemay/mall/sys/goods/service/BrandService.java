package cn.leemay.mall.sys.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.common.data.entity.goods.Brand;
import cn.leemay.mall.sys.goods.form.BrandAddForm;
import cn.leemay.mall.sys.goods.form.BrandGetForm;
import cn.leemay.mall.sys.goods.form.BrandUpdateForm;
import cn.leemay.mall.sys.goods.view.BrandView;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface BrandService extends IService<Brand> {

    /**
     * 添加品牌
     *
     * @param brandAddForm 品牌
     */
    void addBrand(BrandAddForm brandAddForm);

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
     * @param brandGetForm 品牌条件
     * @return 品牌列表
     */
    ResultPage<BrandView> selectList(BrandGetForm brandGetForm);

}
