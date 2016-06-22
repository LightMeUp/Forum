package com.SE3Forum.fzu.Controller.showOther;

import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.TopicService;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.platForumType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Feng on 5/26/16.
 */
@WebServlet(name = "OtherServlet")
public class OtherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            TopicService topicService = new TopicService();
            // 获取学习板块的帖子
            List<Topic> topicList =  topicService.findTopicWithplatOption(platForumType.OthersPlat);
            List<Topic> notifications = topicService.findTopicWithplatOption(platForumType.Notification);


            List<UserCount> userCounts = new ArrayList<>();
        userCounts.add(new UserCountService().findService(221300201));
        userCounts.add(new UserCountService().findService(221300202));
        userCounts.add(new UserCountService().findService(221300205));
        userCounts.add(new UserCountService().findService(221300136));
        userCounts.add(new UserCountService().findService(221300137));
        userCounts.add(new UserCountService().findService(221300138));
        request.setAttribute("topics",topicList);
        request.setAttribute("notification",notifications);
        request.setAttribute("users",userCounts);
            request.getRequestDispatcher(request.getContextPath()+"/Other/all.jsp").forward(request,response);

    }
}
