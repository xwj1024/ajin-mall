package cn.leemay.mall.goods.service;

import cn.leemay.mall.common.base.result.ResultPage;
import cn.leemay.mall.goods.entity.Brand;
import cn.leemay.mall.goods.entity.dto.BrandDTO;
import cn.leemay.mall.goods.entity.vo.BrandInsertVO;
import cn.leemay.mall.goods.entity.vo.BrandSelectVO;
import cn.leemay.mall.goods.entity.vo.BrandUpdateVO;
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
public interface BrandService extends IService<Brand> {

    /**
     * 添加品牌
     *
     * @param brandInsertVO 品牌
     */
    void insertBrand(BrandInsertVO brandInsertVO);

    /**
     * 根据id删除品牌
     *
     * @param id 主键id
     */
    void deleteBrand(Long id);

    /**
     * 修改品牌
     *
     * @param brandUpdateVO 品牌
     */
    void updateBrand(BrandUpdateVO brandUpdateVO);

    /**
     * 根据id查询品牌
     *
     * @param id id
     * @return 品牌
     */
    BrandDTO selectOneById(Long id);

    /**
     * 根据条件查询品牌
     *
     * @param brandSelectVO 品牌条件
     * @return 品牌列表
     */
    List<BrandDTO> selectListByCondition(BrandSelectVO brandSelectVO);

    /**
     * 根据条件分页查询品牌
     *
     * @param brandSelectVO 品牌条件
     * @param index         当前页
     * @param size          每页数
     * @return 分页品牌
     */
    ResultPage<BrandDTO> selectPageByCondition(BrandSelectVO brandSelectVO, Integer index, Integer size);
}
