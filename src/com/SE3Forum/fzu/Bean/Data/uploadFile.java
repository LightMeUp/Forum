package com.SE3Forum.fzu.Bean.Data;

import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Bean.Post_Comments.image;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

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
    private String name;

    //文件唯一辨别码
    private String uuid;

    //发帖用户
    private UserCount user;

    private String description;


    // 创建日期
    private String uploadDate;

    private String validateDate;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(unique =  true)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(String validateDate) {
        this.validateDate = validateDate;
    }
    @ManyToOne
    public UserCount getUser() {
        return user;
    }

    public void setUser(UserCount user) {
        this.user = user;
    }
}