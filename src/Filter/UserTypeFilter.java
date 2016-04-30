package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Feng on 4/21/16.
 */
@WebFilter(filterName = "UserTypeFilter")
// 用于检测用户类型,根据检测的不同用户类型.跳转到指定界面



public class UserTypeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
