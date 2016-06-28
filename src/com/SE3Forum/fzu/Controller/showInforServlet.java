package com.SE3Forum.fzu.Controller;
import com.SE3Forum.fzu.Bean.users.User;
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

/**
 * Created by Feng on 5/23/16.
 */
@WebServlet(name = "showInforServlet")
public class showInforServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
                UserCountService Service = new UserCountService();
               UserCount userCount =  Service.findService(Integer.parseInt(id));
            if (userCount == null){
                System.out.println("帐号不存在");
            }
            else{
                UserCount sessionUser = (UserCount) request.getSession().getAttribute("user");
                if (!Utils.isLoginBySession(request.getSession())){
                    request.setAttribute("isWatch","false");
                }else {

                    if (!id.equals(sessionUser.getId())) {
                        User watch = (User) new UserDao().find(User.class, Integer.parseInt(id));
                        User user = (User) new UserDao().find(User.class, Integer.parseInt("" + sessionUser.getId()));

                        request.setAttribute("isWatch", Utils.isWatched(watch, user));
                    }
                }
                request.setAttribute("userCount", userCount);
                User user = (User) new UserDao().find(User.class, userCount.getId());
                request.setAttribute("user", user);
                request.setAttribute("friends",new UserDao().getFriends(user.getId()));
                request.setAttribute("topics",new UserDao().getTopics(user.getId()));
                request.getRequestDispatcher(request.getContextPath() + "/showCountInfor.jsp").forward(request, response);
            }

        }
}
