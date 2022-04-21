package ajin.mall.sys.auth;

import ajin.mall.sys.common.anno.EnableSecurity;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Ajin
 * @since 2021-05-16
 */
@EnableSecurity
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class SysAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysAuthApplication.class, args);
    }
}
