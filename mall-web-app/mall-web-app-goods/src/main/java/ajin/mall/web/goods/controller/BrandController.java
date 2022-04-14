package ajin.mall.web.goods.controller;

import ajin.mall.web.goods.service.BrandService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 品牌控制器
 *
 * @author Ajin
 * @date 2022/04/14
 */
@RestController
@RequestMapping("/brand")
@Api(tags = "品牌")
@CrossOrigin
public class BrandController {

    @Resource
    private BrandService brandService;

}
