package ajin.mall.common.base.config;

import ajin.mall.common.base.property.SwaggerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


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

    @Resource
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.OAS_30)
                // 基本信息
                .apiInfo(apiInfo())
                // 选择条件
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                // 安全配置
                .securitySchemes(securitySchemes()).securityContexts(securityContexts()).pathMapping("/");
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


    /**
     * 安全模式，指定token通过Authorization请求头传递
     */
    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> apiKeyList = new ArrayList<>();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }

    /**
     * 安全上下文
     */
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(securityReferences())
                        .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                        .build());
        return securityContexts;
    }

    /**
     * 默认的全局鉴权策略
     */
    private List<SecurityReference> securityReferences() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

}
