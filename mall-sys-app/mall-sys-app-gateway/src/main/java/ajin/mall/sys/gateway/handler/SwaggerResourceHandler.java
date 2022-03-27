package ajin.mall.sys.gateway.handler;

import ajin.mall.sys.gateway.config.SwaggerResourceConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger.web.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ajin
 * @since 2022-3-27
 */
@RestController
@RequestMapping("/swagger-resources")
public class SwaggerResourceHandler {

    @Resource
    private SwaggerResourceConfig swaggerResourceConfig;


    @RequestMapping(value = "/configuration/security")
    public ResponseEntity<SecurityConfiguration> securityConfiguration() {
        return new ResponseEntity<>(SecurityConfigurationBuilder.builder().build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/configuration/ui")
    public ResponseEntity<UiConfiguration> uiConfiguration() {
        return new ResponseEntity<>(UiConfigurationBuilder.builder().build(), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<List<SwaggerResource>> swaggerResources() {
        return new ResponseEntity<>(swaggerResourceConfig.get(), HttpStatus.OK);
    }
}
