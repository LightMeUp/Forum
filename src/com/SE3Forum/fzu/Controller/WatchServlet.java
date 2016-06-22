package com.SE3Forum.fzu.Controller;

import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Dao.UserDao;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Feng on 6/15/16.
 */
@WebServlet(name = "WatchServlet")
public class WatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if(!Utils.isLoginBySession(request.getSession())){
            Writer out = response.getWriter();
            out.write("<script>alert('还未登录,请先登录'); window.location='/login.jsp'</script>");
        }else {
            String id = request.getParameter("id");
            System.out.println("id"+id);
            String url =request.getRequestURI();
            System.out.println("url"+url);
            UserCount userCount =(UserCount) request.getSession().getAttribute("user");
            // 被添加用户
            UserCount guest = new UserCountService().findService(Integer.parseInt(id));
            new UserDao().addFriend(userCount.getId(), guest);
            request.setAttribute("isWatch", true);
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
