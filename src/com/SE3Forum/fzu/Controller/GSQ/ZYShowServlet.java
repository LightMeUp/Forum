package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Service.SchoolAssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhu on 2016/6/26.
 */
@WebServlet(name = "ZYShowServlet")
public class ZYShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SchoolAssignment> schoolAssignments=new SchoolAssignmentService().listAllService("schoolAssignment");
        request.setAttribute("ZY",schoolAssignments);
        request.getRequestDispatcher(request.getContextPath()+"/GSQZY.jsp").forward(request,response);
    }
}
