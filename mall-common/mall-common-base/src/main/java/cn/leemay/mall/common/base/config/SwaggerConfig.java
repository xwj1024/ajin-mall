package cn.leemay.mall.common.base.config;

import cn.leemay.mall.common.base.property.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;


/**
 * @author Ajin
 * @since 2021-04-14
 * swagger自定义配置信息
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket docket(Environment environment) {

        // 设置swagger要显示的环境
        Profiles profiles = Profiles.of("dev", "tes");

        // 判断是否属于要显示的环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                // 是否启用swagger
                //.enable(flag)
                .enable(swaggerProperties.getEnable())
                // 设置组名
                .groupName(swaggerProperties.getGroup())
                // 选择条件
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }

    /**
     * 配置swagger api信息
     *
     * @return api信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(swaggerProperties.getTitle() + " api文档",
                swaggerProperties.getDesc(),
                swaggerProperties.getVersion(),
                "https://github.com/xwj1024/leemay-mall",
                contact(),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

    /**
     * 配置 作者信息,联系方式
     *
     * @return 作者信息
     */
    private Contact contact() {
        return new Contact("Ajin", "https://github.com/xwj1024/leemay-mall", "xwj1024@yeah.net");
    }
}
