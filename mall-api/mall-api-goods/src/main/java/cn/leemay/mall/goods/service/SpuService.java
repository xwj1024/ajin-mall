package cn.leemay.mall.goods.service;

import cn.leemay.mall.goods.entity.Spu;
import cn.leemay.mall.goods.entity.Spu;
import cn.leemay.mall.goods.entity.vo.SpuInsertVO;
import cn.leemay.mall.goods.entity.vo.SpuSelectVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品spu表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface SpuService extends IService<Spu> {
    
    /**
     * 添加spu
     *
     * @param spuInsertVO spu
     */
    void insertSpu(SpuInsertVO spuInsertVO);

    /**
     * 根据id删除spu
     *
     * @param id id
     */
    void deleteSpu(Long id);

    /**
     * 修改spu
     *
     * @param spu spu
     */
    void updateSpu(Spu spu);

    /**
     * 根据id查询spu
     *
     * @param id id
     * @return spu
     */
    Spu selectOneById(Long id);

    /**
     * 根据条件查询spu
     *
     * @param spuSelectVO spuSelectVO
     * @return spu列表
     */
    List<Spu> selectListByCondition(SpuSelectVO spuSelectVO);

    /**
     * 根据条件分页查询spu
     *
     * @param spuSelectVO   spuSelectVO
     * @param index 当前页码
     * @param size  每页条数
     * @return spu分页数据
     */
    Page<Spu> selectPageByCondition(SpuSelectVO spuSelectVO, Integer index, Integer size);
}
