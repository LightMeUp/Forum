package com.SE3Forum.fzu.Controller.post;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.FilesService;
import com.SE3Forum.fzu.Service.TopicService;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Feng on 5/25/16.
 */
public class post extends ActionSupport {
    /*帖子中包含的内容包括 主题 , 内容 ,文件(0-N),图片(0-N)
    *图片和文件的上传方式都一样,但是最后的保存方式位置不一样
     *  */

    // 帖子内容
    private String theme;
    private String content;
    private File file;



    public String  execute(){
        System.out.println("processing .......");

        // 首先从Cookie中获取用户的登录信息
        String userId="";
        List<uploadFile> uploadFiles=new ArrayList<>();

        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies= request.getCookies();
        if (Utils.isLogin(request.getCookies())){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("count")){
                    // 获取用户帐号
                    userId= cookie.getValue();
                    System.out.println(userId);
                    break;
                }
            }
        }


        UserCount userCount = new UserCountService().findService(Integer.parseInt(userId));

        if (userCount==null){
            System.out.println("用户不存在");
            return ERROR;
        }
        else {
            TopicService topicService = new TopicService();

            //  创建一个新的主题帖子
            Topic  topic = new Topic();
            // 设置主题
            topic.setTheme(theme);
            topic.setContent(content);
            topic.setCreateDate(Utils.getCurrentDate());
            topic.setUser(userCount);

        }
        return SUCCESS;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

}
