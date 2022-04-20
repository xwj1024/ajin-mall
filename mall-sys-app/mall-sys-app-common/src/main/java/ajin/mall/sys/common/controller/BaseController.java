package ajin.mall.sys.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基本控制器
 *
 * @author Ajin
 * @date 2022/04/18
 */
public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
}
