package cn.leemay.mall.common.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * druid自定义配置信息
 *
 * @author Ajin
 * @since 2021-06-18
 */
@Configuration
public class DruidConfig {

    private static final String LOGIN_USERNAME = "loginUsername";
    private static final String LOGIN_PASSWORD = "loginPassword";
    private static final String[] URL_MAPPINGS = {"/druid/*"};

    @Autowired
    private DruidStatProperties druidStatProperties;

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * druid后台监控
     *
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), URL_MAPPINGS);

        Map<String, String> initParameters = new HashMap<>(2);
        initParameters.put(LOGIN_USERNAME, druidStatProperties.getStatViewServlet().getLoginUsername() == null ?
                UUID.randomUUID().toString() : druidStatProperties.getStatViewServlet().getLoginUsername());
        initParameters.put(LOGIN_PASSWORD, druidStatProperties.getStatViewServlet().getLoginPassword() == null ?
                UUID.randomUUID().toString() : druidStatProperties.getStatViewServlet().getLoginPassword());
        servletRegistrationBean.setInitParameters(initParameters);

        return servletRegistrationBean;
    }
}
