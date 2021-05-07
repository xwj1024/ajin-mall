package cn.leemay.mall.common.base.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义业务异常
 *
 * @author Ajin
 * @since 2021-04-13
 */
@Data
public class BusException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;
    private Throwable cause;

    public BusException() {
        super();
    }

    public BusException(String message) {
        super(message);
        this.message = message;
    }

    public BusException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    public BusException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public BusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
