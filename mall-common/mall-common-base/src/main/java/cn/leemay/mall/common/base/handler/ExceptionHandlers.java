package cn.leemay.mall.common.base.handler;

import cn.leemay.mall.common.base.exception.BizException;
import cn.leemay.mall.common.base.exception.SysException;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.common.base.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    public BaseResult<String> handleSysException(SysException e) {
        log.error(e.getMessage());
        return new BaseResult<>(ResultCode.ERR, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>(1);
            bindingResult.getFieldErrors().forEach(fieldError ->
                    errMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
            log.error(e.getMessage());
            return new BaseResult<>(ResultEnum.PARAM_ERR, errMap);
        }
        log.error(e.getMessage());
        return new BaseResult<>(ResultEnum.PARAM_ERR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResult<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        Map<String, String> errMap = new HashMap<>(1);
        if (constraintViolations != null && constraintViolations.size() > 0) {
            for (ConstraintViolation<?> constraintViolation : constraintViolations) {
                Path propertyPath = constraintViolation.getPropertyPath();
                String path = propertyPath.toString();
                String[] mp = path.split("\\.");
                String message = constraintViolation.getMessage();
                errMap.put(mp[1], message);
            }
            log.error(e.getMessage());
            return new BaseResult<>(ResultEnum.PARAM_ERR, errMap);
        }
        log.error(e.getMessage());
        return new BaseResult<>(ResultEnum.PARAM_ERR);
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResult<String> handleRuntimeException(Exception e) {
        log.error(e.getMessage());
        return new BaseResult<>(ResultCode.ERR, e.getMessage());
    }

}
