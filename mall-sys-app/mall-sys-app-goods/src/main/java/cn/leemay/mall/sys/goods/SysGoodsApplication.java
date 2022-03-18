package cn.leemay.mall.sys.goods;

import cn.leemay.mall.common.data.anno.EnableCascadeDelete;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author Ajin
 * @since 2021-04-13
 */
@SpringBootApplication
@EnableCascadeDelete
@MapperScan(basePackages = {"cn.leemay.mall.**.mapper"})
public class SysGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysGoodsApplication.class, args);
    }
}
