package cn.leemay.mall.common.base.handler;

import cn.leemay.mall.common.base.exception.BizException;
import cn.leemay.mall.common.base.exception.SysException;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.SystemException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ajin
 * @since 2021-04-13
 */
@Slf4j
@RestControllerAdvice("cn.leemay.mall")
public class ExceptionHandlers {

    @ExceptionHandler(BizException.class)
    public BaseResult<String> handleBizException(BizException e) {
        log.error(e.getMessage());
        return new BaseResult<>(ResultCode.ERR, e.getMessage());
    }

    @ExceptionHandler(SysException.class)
    public BaseResult<String> handleSysException(SystemException e) {
        log.error(e.getMessage());
        return new BaseResult<>(ResultCode.ERR, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            Map<String, String> errMap = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
            log.error(e.getMessage());
            return new BaseResult<>(ResultCode.ERR, e.getMessage(), errMap);
        }
        log.error(e.getMessage());
        return new BaseResult<>(ResultCode.ERR, e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResult<String> handleConstraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage());
        return new BaseResult<>(ResultCode.ERR, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResult<String> handleRuntimeException(Exception e) {
        log.error(e.getMessage());
        return new BaseResult<>(ResultCode.ERR, e.getMessage());
    }

}
