package ajin.mall.web.goods.controller;

import ajin.mall.web.goods.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类别控制器
 *
 * @author Ajin
 * @date 2022/04/14
 */
@RestController
@RequestMapping("/category")
@Api(tags = "分类")
@CrossOrigin
public class CategoryController {

    @Resource
    private CategoryService categoryService;
}
