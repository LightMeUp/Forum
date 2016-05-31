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
        isLogin(request,response);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }
    public  void isLogin(HttpServletRequest request, HttpServletResponse response){
        Cookie[]cookies =request.getCookies();
        HttpSession session=request.getSession();
        UserCount userCount=new UserCount();
        if (cookies == null ||cookies.length <2)
        {
            System.out.println("cookie 不存在,用户未登录");
            request.setAttribute("loginState","NO");
            // 获取Session
             session = request.getSession();
            // 记录登录状态,即游客登录模式
            session.setAttribute("loginState","NO");
            return ;
        }
        System.out.println("Cookie exists");
        String id="";
        String securityToken="";
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("count")) {
                id = cookie.getValue();
                 userCount =  new UserCountService().findService(Integer.parseInt(id));
                securityToken = userCount.getSecurityToken();
            }
            if (cookie.getName().equals("sercurityToken"))
            {
                System.out.println("已经登录用户安全码:"+securityToken);
                if (cookie.getValue().equals(securityToken))
                {
                    System.out.println("用户已经登录");
                    session = request.getSession();
                    userCount.setLastLoginDate(Utils.getCurrentDate());
                    new UserCountService().updateServcie(userCount);
                    session.setAttribute("userCount",userCount);
                }
                else {
                    session.setAttribute("loginState","NO");
                }

            }
        }
    }

}
