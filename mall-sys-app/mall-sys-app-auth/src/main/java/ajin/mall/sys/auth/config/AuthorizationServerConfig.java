package ajin.mall.sys.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * 授权服务器配置
 *
 * @author Ajin
 * @date 2022/04/15
 */
@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Resource
//    private DataSource dataSource;
//
//    @Resource
//    private JwtAccessTokenConverter jwtAccessTokenConverter;
//
//    @Resource
//    UserDetailsService userDetailsService;
//
//    @Resource
//    AuthenticationManager authenticationManager;
//
//    @Resource
//    TokenStore tokenStore;
//
//    @Resource
//    private CustomUserAuthenticationConverter customUserAuthenticationConverter;
//
//    /**
//     * 客户端服务配置
//     *
//     * @param clients 客户
//     * @throws Exception 异常
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        // 动态获取客户端信息
//        clients.jdbc(dataSource)
//                .clients(clientDetails());
//    }
//
//    /**
//     * 配置*
//     * 授权服务器端点配置
//     *
//     * @param endpoints 端点
//     * @throws Exception 异常
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.accessTokenConverter(jwtAccessTokenConverter)
//                .authenticationManager(authenticationManager)
//                .tokenStore(tokenStore)
//                .userDetailsService(userDetailsService);
//    }
//
//    /**
//     * 配置*
//     * 授权服务器的安全配置
//     *
//     * @param oauthServer oauth服务
//     * @throws Exception 异常
//     */
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        oauthServer.allowFormAuthenticationForClients()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()");
//    }
//
//    @Bean("keyProperties")
//    public KeyProperties keyProperties() {
//        return new KeyProperties();
//    }
//
//    @Resource(name = "keyProperties")
//    private KeyProperties keyProperties;
//
//    @Bean
//    public ClientDetailsService clientDetails() {
//        return new JdbcClientDetailsService(dataSource);
//    }
//
//    @Bean
//    @Autowired
//    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
//        return new JwtTokenStore(jwtAccessTokenConverter);
//    }
//
//    /**
//     * JWT令牌转换器
//     *
//     * @param customUserAuthenticationConverter 自定义用户身份验证转换器
//     * @return {@link JwtAccessTokenConverter}
//     */
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter(CustomUserAuthenticationConverter customUserAuthenticationConverter) {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        KeyPair keyPair = new KeyStoreKeyFactory(keyProperties.getKeyStore().getLocation(), keyProperties.getKeyStore().getSecret().toCharArray())
//                .getKeyPair(keyProperties.getKeyStore().getAlias(), keyProperties.getKeyStore().getPassword().toCharArray());
//        converter.setKeyPair(keyPair);
//        // 配置自定义的CustomUserAuthenticationConverter
//        DefaultAccessTokenConverter accessTokenConverter = (DefaultAccessTokenConverter) converter.getAccessTokenConverter();
//        accessTokenConverter.setUserTokenConverter(customUserAuthenticationConverter);
//        return converter;
//    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        super.configure(clients);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }
}


