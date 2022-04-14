package ajin.mall.web.member;

import ajin.mall.common.data.anno.EnableCascade;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 网络成员应用程序
 *
 * @author Ajin
 * @date 2022/04/14
 */
@SpringBootApplication
@EnableCascade
@MapperScan(basePackages = {"ajin.mall.**.mapper"})
public class WebMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebMemberApplication.class, args);
    }
}
