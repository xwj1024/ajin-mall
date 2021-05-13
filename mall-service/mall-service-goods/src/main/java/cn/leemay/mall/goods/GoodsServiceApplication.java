package cn.leemay.mall.goods;

import cn.leemay.mall.common.db.anno.EnableMybatisPlus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author Ajin
 * @create 2021-04-13
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableMybatisPlus
public class GoodsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsServiceApplication.class, args);
    }
}
