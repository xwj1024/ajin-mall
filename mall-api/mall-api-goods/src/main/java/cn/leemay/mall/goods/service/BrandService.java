package cn.leemay.mall.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.Brand;
import cn.leemay.mall.goods.entity.view.BrandView;
import cn.leemay.mall.goods.entity.form.BrandInsertForm;
import cn.leemay.mall.goods.entity.form.BrandSelectForm;
import cn.leemay.mall.goods.entity.form.BrandUpdateForm;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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
    BrandView selectOneById(Long id);

    /**
     * 根据条件查询品牌
     *
     * @param brandSelectForm 品牌条件
     * @return 品牌列表
     */
    List<BrandView> selectListByCondition(BrandSelectForm brandSelectForm);

    /**
     * 根据条件分页查询品牌
     *
     * @param brandSelectForm 品牌条件
     * @param index           当前页
     * @param size            每页数
     * @return 分页品牌
     */
    ResultPage<BrandView> selectPageByCondition(BrandSelectForm brandSelectForm, Integer index, Integer size);
}
