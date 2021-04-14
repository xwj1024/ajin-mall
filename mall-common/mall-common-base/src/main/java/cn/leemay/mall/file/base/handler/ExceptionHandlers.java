package cn.leemay.mall.file.base.handler;

import cn.leemay.mall.file.base.exception.BusException;
import cn.leemay.mall.file.base.result.BaseResult;
import cn.leemay.mall.file.base.result.ResultCode;
import org.omg.CORBA.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ajin
 * @create 2021/4/13
 */
@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value = BusException.class)
    @ResponseBody
    public BaseResult<String> business(SystemException e) {
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
