package com.SE3Forum.fzu.Controller;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Dao.UserDao;
import com.SE3Forum.fzu.Service.FilesService;
import com.SE3Forum.fzu.Service.TopicService;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;
import com.SE3Forum.fzu.Util.platForumType;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.deploy.services.PlatformType;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Feng on 6/17/16.
 */
public class createTopic extends ActionSupport {
    private String  theme; // 帖子主题
    private String type;
    private String content;



    public String  execute(){
        System.out.println(theme);
        System.out.println(content);
        TopicService topicService= new TopicService();
        HttpServletRequest request = ServletActionContext.getRequest();
       if (!Utils.isLoginBySession(request.getSession())){
           return LOGIN;
       }


        UserCount usercount = (UserCount)request.getSession().getAttribute("user");
        Topic topic = new Topic();
        topic.setCreateDate(Utils.getCurrentDate());
        topic.setContent(content);
        topic.setTheme(theme);
        topic.setType(getType(type));
        topic.setUser(usercount);
        topicService.addService(topic);
        User user =(User) new UserDao().find(User.class,usercount.getId());
        Set<Topic> topics = user.getTopics()==null?new HashSet<>():user.getTopics();
        topics.add(topic);

        if (content.contains("<a") && content.contains("</a>")){
            //用户上传了文件
            uploadFile file = new uploadFile();
            file.setUser(user);
            file.setFilepath(Utils.getFileString(content));
            file.setUploadDate(Utils.getCurrentDate());
            new  FilesService().addService(file);
            Set<uploadFile> uploadFiles = user.getFiles()==null?new HashSet<>():user.getFiles();
            uploadFiles.add(file);
            user.setFiles(uploadFiles);
        }

        user.setTopics(topics);
        new  UserDao().update(user);


        List<Topic> topicList =  topicService.findTopicWithplatOption(getplatType(type));
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

        if (type.equals("Study")) return "study";
        else   if (type.equals("Database")) return "other";
        else   if (type.equals("Freezone")) return "freezone";
        else   if (type.equals("Question")) return "question";
        else return "Other";
    }
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType(String type){
        if (type.equals("Study")) return "Study";
        else if (type.equals("Notification")) return "Notification";
        else if (type.equals("Freezone")) return "Freezone";
        else if (type.equals("SubjectDiscuss")) return "SubjectDiscuss";
        else return "Other";
    }
    public platForumType getplatType(String type){
        if (type.equals("Study")) return platForumType.StudyPlat;
        else if (type.equals("Notification")) return platForumType.Notification;
        else if (type.equals("Freezone")) return platForumType.FreeZonePlat;
        else if (type.equals("SubjectDiscuss")) return platForumType.SubjectDiscussPlat;
        else return platForumType.OthersPlat;
    }
}
