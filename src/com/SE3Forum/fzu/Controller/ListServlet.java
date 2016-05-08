package com.SE3Forum.fzu.Controller;

import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Feng on 5/8/16.
 */
@WebServlet(name = "ListServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("hello");
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getQueryString();
        System.out.println("query"+queryString);
        String[] str = queryString.split("=");
        System.out.println(str[0]);
        System.out.println(str[1]);
        if (str[1].equals("student")){
            StudentDao studentDao = new StudentDao();
           List<Student> studentList = studentDao.findEntities("student");
            request.setAttribute("students",studentList);
            request.getRequestDispatcher(request.getContextPath()+"/testJSP/studentlistJSP.jsp").forward(request,response);
        }

    }
}
