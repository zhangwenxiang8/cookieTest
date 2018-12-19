package work.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            servletRequest.setCharacterEncoding("utf-8");  //servletRequest 请求,编码集的方法( 对文档全局有效)

            filterChain.doFilter(servletRequest,servletResponse);   //向后放行,(请求+响应)
    }

    @Override
    public void destroy() {

    }
}
