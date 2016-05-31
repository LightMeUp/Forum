package com.SE3Forum.fzu.Controller.showStudy;

import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Service.SearchOption;
import com.SE3Forum.fzu.Service.TopicService;
import com.SE3Forum.fzu.Util.platForumType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Feng on 5/26/16.
 */
@WebServlet(name = "studyServlet")
public class studyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("获取全部的学习贴");
            TopicService topicService = new TopicService();
            List<Topic> topicList =  topicService.findTopicWithplatOption(platForumType.StudyPlat);
            request.setAttribute("topics",topicList);
            request.getRequestDispatcher(request.getContextPath()+"/study/all.jsp").forward(request,response);

    }
}
