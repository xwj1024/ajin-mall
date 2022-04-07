package ajin.mall.sys.goods.service;

import ajin.mall.common.base.result.ResultPage;
import ajin.mall.common.data.entity.Spu;
import ajin.mall.sys.goods.form.SpuAddForm;
import ajin.mall.sys.goods.form.SpuListForm;
import ajin.mall.sys.goods.form.SpuUpdateForm;

/**
 * <p>
 * 商品spu表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
public interface SpuService {

    /**
     * 添加spu
     *
     * @param spuAddForm spu
     */
    void add(SpuAddForm spuAddForm);

    /**
     * 根据id删除spu
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 修改spu
     *
     * @param spuUpdateForm spu
     */
    void update(SpuUpdateForm spuUpdateForm);

    /**
     * 根据id查询spu
     *
     * @param id id
     * @return spu
     */
    Spu get(Long id);

    /**
     * 根据条件查询spu
     *
     * @param spuListForm spuListForm
     * @return spu列表
     */
    ResultPage<Spu> list(SpuListForm spuListForm);


}
