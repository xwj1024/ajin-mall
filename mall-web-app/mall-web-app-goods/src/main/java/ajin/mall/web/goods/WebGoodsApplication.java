package ajin.mall.web.goods;

import ajin.mall.common.data.anno.EnableCascade;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author A
 */
@SpringBootApplication
@EnableCascade
@MapperScan(basePackages = {"ajin.mall.**.mapper"})
public class WebGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebGoodsApplication.class, args);
    }
}
