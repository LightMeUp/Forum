package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Service.EvaluationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Feng on 6/28/16.
 */
@WebServlet(name = "Evaluation")
public class Evaluation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id =Integer.parseInt(request.getParameter("evaluationId"));
        com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation  evaluation= new EvaluationService().findService(id);
        request.setAttribute("evaluation",evaluation);
        request.getRequestDispatcher("/Evaluation.jsp").forward(request,response);
    }
}
