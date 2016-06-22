package com.SE3Forum.fzu.Bean.Data;

import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Feng on 4/25/16.
 */
/* 用户上传资料数据库只保存文件名,文件具体的存放 改为存放在服务器硬盘下
*  优点1. 数据加载速度快,如果以二进制数据存放在数据库内,数据加载时间过长
*  优点2. 数据不易发生错误
*  优点3. 用户上传一张图片需要对图片进行多种处理,使用数据库不易操作
*  文件在保存到服务器的文件夹时需要修改文件的名字,防止重名导致的文件覆盖*/

@Entity
@Table(name = "uploadFile",schema = "ForumDatabase")
public class uploadFile {

    private int id;

    // 文件名
    private String filepath;

    //文件唯一辨别码
    //发帖用户
    private User user;
    // 创建日期
    private Date uploadDate;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}