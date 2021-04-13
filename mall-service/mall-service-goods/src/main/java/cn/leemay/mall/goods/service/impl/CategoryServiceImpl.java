package cn.leemay.mall.goods.service.impl;

import cn.leemay.mall.goods.entity.Category;
import cn.leemay.mall.goods.mapper.CategoryMapper;
import cn.leemay.mall.goods.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类目表 服务实现类
 * </p>
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
