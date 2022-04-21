package ajin.mall.common.base.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * JWT工具类
 *
 * @author Ajin
 * @since 2021-05-07
 */
public class JwtUtils {

    /**
     * 秘钥明文
     */
    public static final String JWT_KEY = "ajin-mall";
    /**
     * 有效时长
     */
    public static final Long JWT_TTL = 2592000L;

    /**
     * 创建token
     *
     * @param issuer    签发者
     * @param ttlMillis 有效时长
     * @return jwt
     */
    public static String generateJwt(String issuer, Long ttlMillis, Map<String, Object> claims) {
        if (ttlMillis == null || ttlMillis < 0) {
            // 默认30天
            ttlMillis = JwtUtils.JWT_TTL;
        }
        long nowMillis = System.currentTimeMillis();
        long expireMillis = nowMillis + ttlMillis;

        JwtBuilder builder = Jwts.builder()
                .setIssuer(issuer)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, generateKey())
                .setExpiration(new Date(expireMillis))
                .setClaims(claims);
        return builder.compact();
    }

    public static String generateJwt(String issuer, Map<String, Object> claims) {
        return generateJwt(issuer, null, claims);
    }

    public static String generateJwt(Map<String, Object> claims) {
        return generateJwt("Ajin", null, claims);
    }

    /**
     * 生成加密后的秘钥 secretKey
     *
     * @return SecretKey
     */
    public static SecretKey generateKey() {
        byte[] encodedKey = Base64.getEncoder().encode(JwtUtils.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * 解析
     *
     * @param jwt jwt
     * @return 令牌载荷信息
     */
    public static Claims parseJwt(String jwt) {
        SecretKey secretKey = generateKey();
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
    }

}