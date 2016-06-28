package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.TopicService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import sun.security.provider.certpath.SunCertPathBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Feng on 6/28/16.
 */
public class NotificationAction extends ActionSupport {
    private String theme;
    private String content;

    public String  execute(){
        System.out.println("hdfsdfasdf");
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCount userCount =(UserCount)request.getSession().getAttribute("user");
        Topic topic = new Topic();
        topic.setTheme(theme);
        topic.setContent(content);
        topic.setCreateDate(Utils.getCurrentDate());
        topic.setLastUpdateDate(Utils.getCurrentDate());
        topic.setUser(userCount);
        topic.setType("Notification");
        topic.setOnTop(1);
        new TopicService().addService(topic);
        return SUCCESS;
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
}
