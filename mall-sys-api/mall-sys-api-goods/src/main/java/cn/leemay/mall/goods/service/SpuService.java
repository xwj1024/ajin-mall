package cn.leemay.mall.goods.service;

import cn.leemay.mall.goods.entity.Spu;
import cn.leemay.mall.goods.entity.form.SpuInsertForm;
import cn.leemay.mall.goods.entity.form.SpuSelectForm;
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
     * @param spuInsertForm spu
     */
    void insertSpu(SpuInsertForm spuInsertForm);

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
     * @param spuSelectForm spuSelectForm
     * @return spu列表
     */
    List<Spu> selectListByCondition(SpuSelectForm spuSelectForm);

    /**
     * 根据条件分页查询spu
     *
     * @param spuSelectForm   spuSelectForm
     * @param index 当前页码
     * @param size  每页条数
     * @return spu分页数据
     */
    Page<Spu> selectPageByCondition(SpuSelectForm spuSelectForm, Integer index, Integer size);
}
