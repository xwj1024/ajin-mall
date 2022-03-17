package cn.leemay.mall.sys.goods.service;

import cn.leemay.mall.common.data.entity.goods.Spu;
import cn.leemay.mall.sys.goods.form.SpuAddForm;
import cn.leemay.mall.sys.goods.form.SpuListForm;
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
     * @param spuAddForm spu
     */
    void insertSpu(SpuAddForm spuAddForm);

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
     * @param spuListForm spuListForm
     * @return spu列表
     */
    List<Spu> selectListByCondition(SpuListForm spuListForm);

    /**
     * 根据条件分页查询spu
     *
     * @param spuListForm   spuListForm
     * @param index 当前页码
     * @param size  每页条数
     * @return spu分页数据
     */
    Page<Spu> selectPageByCondition(SpuListForm spuListForm, Integer index, Integer size);
}
