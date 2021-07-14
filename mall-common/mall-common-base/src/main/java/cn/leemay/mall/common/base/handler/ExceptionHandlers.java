package cn.leemay.mall.common.base.handler;

import cn.leemay.mall.common.base.exception.BizException;
import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import org.omg.CORBA.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ajin
 * @since 2021-04-13
 */
@ControllerAdvice("cn.leemay.mall")
public class ExceptionHandlers {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public BaseResult<String> business(BizException e) {
        e.printStackTrace();
        return new BaseResult<>(ResultCode.ERR, e.getMessage());
    }

    @ExceptionHandler(value = SystemException.class)
    @ResponseBody
    public BaseResult<String> system(SystemException e) {
        e.printStackTrace();
        return new BaseResult<>(ResultCode.ERR, e.getMessage());
    }


    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public BaseResult<String> error(Exception e) {
        e.printStackTrace();
        return new BaseResult<>(ResultCode.ERR, e.getMessage());
    }

}
