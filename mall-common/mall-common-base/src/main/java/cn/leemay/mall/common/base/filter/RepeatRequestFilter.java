package cn.leemay.mall.common.base.filter;

import cn.leemay.mall.common.base.wrapper.RepeatRequestWrapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Repeatable 过滤器
 *
 * @author ruoyi
 */
@Component
public class RepeatRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest servletRequest = null;
        if (request instanceof HttpServletRequest && StringUtils.startsWithIgnoreCase(request.getContentType(), MediaType.APPLICATION_JSON_VALUE)) {
            servletRequest = new RepeatRequestWrapper((HttpServletRequest) request, response);
        }
        if (null == servletRequest) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(servletRequest, response);
        }
    }

    @Override
    public void destroy() {

    }
}
