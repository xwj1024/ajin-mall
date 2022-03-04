package cn.leemay.mall.auth.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Ajin
 * @since 2021-05-19
 */
@Component
@ConfigurationProperties(prefix = "token")
@Data
public class TokenProperties implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Boolean enable = true;
}
