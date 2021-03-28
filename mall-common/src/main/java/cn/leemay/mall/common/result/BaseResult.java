package cn.leemay.mall.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ajin
 */
@Data
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String desc;
    private T data;

    public BaseResult() {
        this.code = ResultCode.OK;
        this.desc = "成功";
    }

    public BaseResult(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public BaseResult(Integer code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }
}
