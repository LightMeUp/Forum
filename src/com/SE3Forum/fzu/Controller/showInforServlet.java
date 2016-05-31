package com.SE3Forum.fzu.Controller;

import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.UserType;
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


        UserType userType =Utils.getUsertype(id);
        if (userType == UserType.studentType){
                UserCountService Service = new UserCountService();
               UserCount userCount =  Service.findService(Integer.parseInt(id));
            if (userCount == null){
                System.out.println("帐号不存在或者已经退出");
            }
            else{
                request.setAttribute("user",userCount);
                request.getRequestDispatcher(request.getContextPath()+"/showCountInfor.jsp").forward(request,response);

            }

        }

    }
}
