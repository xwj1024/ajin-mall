package cn.leemay.mall.common.base.config;

import cn.leemay.mall.common.base.config.property.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
 * swagger自定义配置信息
 *
 * @author Ajin
 * @since 2021-04-14
 */
@Configuration
@EnableOpenApi
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfig {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                // 是否启用swagger
                //.enable(flag)
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
                "<font color='green'>" + swaggerProperties.getDescription() + "</font>",
                swaggerProperties.getVersion(),
                swaggerProperties.getTermsOfServiceUrl(),
                contact(),
                swaggerProperties.getLicense(),
                swaggerProperties.getLicenseUrl(),
                new ArrayList());

    }

    /**
     * 配置 作者信息,联系方式
     *
     * @return 作者信息
     */
    private Contact contact() {
        return new Contact(swaggerProperties.getContactName(), swaggerProperties.getContactUrl(), swaggerProperties.getContactEmail());
    }
}
