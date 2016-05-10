package com.SE3Forum.fzu.Controller;

import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Service.StudentService;
import com.SE3Forum.fzu.Service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Feng on 5/10/16.
 */
@WebServlet(name = "showPersonalInfor")
public class showPersonalInfor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // url:/controller/showinfor?id=*
        String str =request.getQueryString();
        String []str2 = str.split("=");
        if (str2[1].indexOf("2201")> 1)
        {
            // 教师类型,实例化一个TeacherService
            TeacherService teacherService = new TeacherService();
            //Teacher teacher = teacherService
        }
        else {
            System.out.println("学生");
            StudentService studentService  =new StudentService();
            Student student=  studentService.getStudent(Integer.parseInt(str2[1]));
            request.setAttribute("student",student);
            request.getRequestDispatcher("/personalInfor.jsp").forward(request,response);
        }
    }
}
