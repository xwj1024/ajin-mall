package cn.leemay.mall.common.base.result;


/**
 * @author Ajin
 * @since 2021-06-13
 */
public enum ResultEnum {
    OPERATE_OK(ResultCode.OK, "操作成功"),

    OPERATE_ERR(ResultCode.ERR, "操作失败"),

    ADD_OK(ResultCode.OK, "添加成功"),

    ADD_ERR(ResultCode.ERR, "添加失败"),

    DELETE_OK(ResultCode.OK, "删除成功"),

    DELETE_ERR(ResultCode.ERR, "删除失败"),

    UPDATE_OK(ResultCode.OK, "修改成功"),

    UPDATE_ERR(ResultCode.ERR, "修改失败"),

    GET_OK(ResultCode.OK, "查询成功"),

    GET_ERR(ResultCode.ERR, "查询失败"),

    GET_INFO(ResultCode.INFO, "暂无数据"),

    PARAM_ERR(ResultCode.ERR, "参数有误");

    private final int    code;
    private final String desc;

    ResultEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
