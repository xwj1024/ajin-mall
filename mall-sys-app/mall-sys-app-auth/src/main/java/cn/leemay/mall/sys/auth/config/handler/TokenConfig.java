package cn.leemay.mall.sys.auth.config.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 令牌配置
 *
 * @author Ajin
 * @since 2021-05-19
 */
@Configuration
public class TokenConfig {
    private static final String SIGN_KEY = "leemay";

    @Bean
    public TokenStore tokenStore() {
        // jwt存储方案
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        // 对称密钥
        jwtAccessTokenConverter.setSigningKey(SIGN_KEY);
        return jwtAccessTokenConverter;
    }
}
