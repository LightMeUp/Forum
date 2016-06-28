package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Dao.UserDao;
import com.SE3Forum.fzu.Service.FilesService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.tools.doclets.internal.toolkit.Content;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Feng on 6/28/16.
 */
public class dataUpload extends ActionSupport {
    private String desc;
    private String content;

    public String execute(){

        HttpServletRequest request = ServletActionContext.getRequest();
        UserCount userCount = (UserCount) request.getSession().getAttribute("user");
        User user = (User)new UserDao().find(User.class,userCount.getId());

        uploadFile file = new uploadFile();
        file.setUser(user);
        file.setFilepath(Utils.getFileString(content));
        file.setUploadDate(Utils.getCurrentDate());
        new FilesService().addService(file);
        Set<uploadFile> uploadFiles = user.getFiles()==null?new HashSet<>():user.getFiles();
        uploadFiles.add(file);
        user.setFiles(uploadFiles);
        return SUCCESS;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
