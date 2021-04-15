package cn.leemay.mall.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Ajin
 * @create 2021/4/14
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FileServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileServiceApplication.class, args);
    }
}
