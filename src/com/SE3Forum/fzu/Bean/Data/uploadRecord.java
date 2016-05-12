package com.SE3Forum.fzu.Bean.Data;

import com.SE3Forum.fzu.Bean.users.User;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Feng on 4/25/16.
 */
@Entity
@Table(name = "uploadingRecord",schema = "ForumDataBase")
public class uploadRecord {

    //上传记录编号
    private int id;

    // 文件上传用户
    private User user;

    // 上传日期
    private Date uploadDate;


    public Date getUploadDate() {
        return uploadDate;
    }
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public User getUser() {return user;}
    public void setUser(User user) {
        this.user = user;
    }

}
