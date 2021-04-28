package cn.leemay.mall.goods;

import cn.leemay.mall.common.base.anno.EnableHandler;
import cn.leemay.mall.common.base.anno.EnableSwagger;
import cn.leemay.mall.common.db.anno.EnableMybatisPlus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author Ajin
 * @create 2021-04-13
 */
@SpringBootApplication
@EnableSwagger
@EnableDiscoveryClient
@EnableMybatisPlus
@EnableHandler
public class GoodsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsServiceApplication.class, args);
    }
}
