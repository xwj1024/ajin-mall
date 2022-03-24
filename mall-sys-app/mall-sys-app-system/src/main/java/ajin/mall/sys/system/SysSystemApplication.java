package ajin.mall.sys.system;

import ajin.mall.sys.common.anno.EnableRecordSysOperateLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ajin
 * @since 2021-05-13
 */
@SpringBootApplication
@MapperScan(basePackages = {"ajin.mall.**.mapper"})
@EnableRecordSysOperateLog
public class SysSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysSystemApplication.class, args);
    }
}
