package ajin.mall.common.base.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 自定义业务异常
 *
 * @author Ajin
 * @since 2021-04-13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;
    private Throwable cause;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
        this.message = message;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    public BizException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
