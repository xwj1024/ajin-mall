package ajin.mall.sys.auth;

import ajin.mall.sys.common.anno.EnableSecurity;
import ajin.mall.sys.common.anno.EnableSysLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ajin
 * @since 2021-05-16
 */
@EnableSecurity
@EnableSysLog
@MapperScan(basePackages = {"ajin.mall.**.mapper"})
@SpringBootApplication
public class SysAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysAuthApplication.class, args);
    }
}
