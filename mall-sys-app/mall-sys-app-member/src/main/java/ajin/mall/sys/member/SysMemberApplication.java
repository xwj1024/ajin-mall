package ajin.mall.sys.member;

import ajin.mall.common.data.anno.EnableCascade;
import ajin.mall.sys.common.anno.EnableSysLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ajin
 * @since 2021-05-13
 */
@EnableSysLog
@EnableCascade
@SpringBootApplication
@MapperScan(basePackages = {"ajin.mall.**.mapper"})
public class SysMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysMemberApplication.class, args);
    }
}
