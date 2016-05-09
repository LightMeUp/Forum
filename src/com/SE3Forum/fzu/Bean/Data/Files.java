package com.SE3Forum.fzu.Bean.Data;

import com.SE3Forum.fzu.Bean.users.User;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Feng on 4/25/16.
 */
/* 用户上传资料数据库只保存文件名,文件具体的存放 改为存放在服务器硬盘下
*  优点1. 数据加载速度快,如果以二进制数据存放在数据库内,数据加载时间过长
*  优点2. 数据不易发生错误
*  优点3. 用户上传一张图片需要对图片进行多种处理,使用数据库不易操作
*  文件在保存到服务器的文件夹时需要修改文件的名字,防止重名导致的文件覆盖*/

@Entity
@Table(name = "Files",schema = "ForumDataBase")
public class Files {
    // 上传资料编号
    private int id;

    //文件真实名称
    private String FileName;

    // 保存文件名
    private String uuid;

    // 上传用户
    private User user;

    //上传日期
    private Date uploadingDate;

    // 有效时间
    private Date validateDate;

    //文件描述
    private String desc;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "filename")
    public String getFileName() {
        return FileName;
    }
    public void setFileName(String fileName) {
        FileName = fileName;
    }

    @Column(name = "uploadingdate")
    public Date getUploadingDate() {
        return uploadingDate;
    }
    public void setUploadingDate(Date uploadingDate) {
        this.uploadingDate = uploadingDate;
    }

    @Column(name = "validatedate")
    public Date getValidateDate() {
        return validateDate;
    }
    public void setValidateDate(Date validateDate) {
        this.validateDate = validateDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}