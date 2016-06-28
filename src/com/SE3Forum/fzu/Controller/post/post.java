package com.SE3Forum.fzu.Controller.post;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Dao.UserDao;
import com.SE3Forum.fzu.Service.FilesService;
import com.SE3Forum.fzu.Service.TopicService;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Service.postService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Feng on 5/25/16.
 */
public class post extends ActionSupport {
    /*帖子中包含的内容包括 主题 , 内容 ,文件(0-N),图片(0-N)
    *图片和文件的上传方式都一样,但是最后的保存方式位置不一样
     *  */

    // 帖子内容
    private String  topicId;
    private String content;



    public String  execute() throws IOException {
        // 首先从Cookie中获取用户的登录信息
        String userId="";
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies= request.getCookies();
        HttpSession session = request.getSession();
        UserCount userCount= (UserCount) session.getAttribute("user");
        if(userCount == null){
            System.out.println("not login yet");
            return LOGIN;
        }

        // 帖子是属于哪个主题贴
        // 帖子发出时间
        // 发帖人
        Topic topic = new TopicService().findService(Integer.parseInt(topicId));
        Post post = new Post();
        post.setTopic(topic);
        // 发帖用户
        post.setUser(userCount);
        // 发帖日期
        post.setCreateDate(Utils.getCurrentDate());
        // 发帖内容
        post.setContent(content);
        postService service = new postService();
        service.addService(post);

        // 发帖用户添加发帖
        User user = (User)new UserDao().find(User.class,userCount.getId());
        // 用户是否发过贴
        Set<Post> posts = user.getPosts()==null?new HashSet<>():user.getPosts();
        posts.add(post);
        user.setPosts(posts);

        //主题贴中加入新的帖子
        posts= topic.getPosts()==null?new HashSet<>():topic.getPosts();
        posts.add(post);
        topic.setPosts(posts);
        topic.setLastUpdateDate(new Date());
        new TopicService().updateServcie(topic);

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
            new UserDao().update(user);
        }



        String refer ="/topics?topicid="+topicId;
        HttpServletResponse response = ServletActionContext.getResponse();
        response.sendRedirect(refer);
        System.out.println(refer);
        return null;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }
}
