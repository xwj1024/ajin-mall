package cn.leemay.mall.common.base.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 * @create 2021/4/13
 * 自定义系统异常
 */
@Data
public class SysException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;
    private Throwable cause;

    public SysException() {
        super();
    }

    public SysException(String message) {
        super(message);
        this.message = message;
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    public SysException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public SysException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
