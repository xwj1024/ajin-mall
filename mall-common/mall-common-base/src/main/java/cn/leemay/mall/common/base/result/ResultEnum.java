package cn.leemay.mall.common.base.result;


/**
 * @author Ajin
 * @since 2021-06-13
 */
public enum ResultEnum {
    INSERT_OK(ResultCode.OK, "添加成功"),
    INSERT_ERR(ResultCode.ERR, "添加失败"),
    DELETE_OK(ResultCode.OK, "删除成功"),
    DELETE_ERR(ResultCode.ERR, "删除失败"),
    UPDATE_OK(ResultCode.OK, "修改成功"),
    UPDATE_ERR(ResultCode.ERR, "修改失败"),
    SELECT_OK(ResultCode.OK, "查询成功"),
    SELECT_ERR(ResultCode.ERR, "查询失败"),
    SELECT_INFO(ResultCode.INFO, "暂无数据");

    private final int code;
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
