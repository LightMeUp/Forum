package com.SE3Forum.fzu.Controller;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Service.TopicService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Feng on 6/5/16.
 */
@WebServlet
public class showStudyTopic extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 请求某个帖子的url  /study/topic?topicid=[0-9]*
        String topicId = request.getParameter("topicid");
        TopicService service = new TopicService();
        System.out.printf("topic id=%s\n",topicId);
        Topic topic =  service.findService(Integer.parseInt(topicId));
        if (topic==null){
            System.out.println("404 not found");
            request.getRequestDispatcher(request.getContextPath()+"/study/error.jsp").forward(request,response);
        }
        request.setAttribute("topic",topic);
        System.out.println(topic.getPosts());
        request.getRequestDispatcher(request.getContextPath()+"/topic.jsp").forward(request,response);
    }
}
