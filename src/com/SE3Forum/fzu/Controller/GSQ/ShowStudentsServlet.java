package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by Feng on 6/28/16.
 */
@WebServlet(name = "ShowStudentsServlet")
public class ShowStudentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String teacherId =request.getParameter("teacherId");
        Teacher teacher = new TeacherService().findService(Teacher.class,Integer.parseInt(teacherId));
        request.setAttribute("students",teacher.getStudents());
        request.getRequestDispatcher("/Mystudents.jsp").forward(request,response);

    }
}
