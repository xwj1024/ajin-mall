package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.goods.entity.Spec;
import cn.leemay.mall.goods.mapper.SpecMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品规格表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-05-22
 */
@Service
public class SpecServiceImpl extends ServiceImpl<SpecMapper, Spec> implements IService<Spec> {

}
