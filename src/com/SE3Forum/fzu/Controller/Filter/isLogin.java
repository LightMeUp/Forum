package com.SE3Forum.fzu.Controller.Filter;

import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Feng on 5/23/16.
 */
@WebFilter(filterName = "isLogin")
/*
*  用户登录时,服务器检查用户的的本地是否存在COOKIE 以及COOkie中包含的参数是否正确
*  如果正确,使用session 记入用户的登录信息,修改用户的登录时间*/
public class isLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        System.out.println(" filter:islogin 检查用户是否登录");
        if(!Utils.isLoginBySession(request.getSession())){
            Writer out = response.getWriter();
            out.write("<script>alert('还未登录,操作取消,请先登录');window.location='/login.jsp'</script>");
        }
        else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
