package ajin.mall.sys.goods;

import ajin.mall.common.data.anno.EnableCascade;
import ajin.mall.sys.common.anno.EnableRecordSysLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author Ajin
 * @since 2021-04-13
 */
@SpringBootApplication
@EnableCascade
@MapperScan(basePackages = {"ajin.mall.**.mapper"})
@EnableRecordSysLog
public class SysGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysGoodsApplication.class, args);
    }
}
