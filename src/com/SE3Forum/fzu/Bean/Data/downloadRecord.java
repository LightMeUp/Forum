package com.SE3Forum.fzu.Bean.Data;

import com.SE3Forum.fzu.Bean.users.User;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Feng on 4/25/16.
 */
@Entity
@Table(name = "downloadrecord",schema = "ForumDataBase")
public class downloadRecord {
    // 下载记录编号
    private int id;
    // 资料
    private uploadFile file;
    // 下载用户
    private  User user;
    // 下载日期
    private String downloadDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    public uploadFile getData() {
        return file;
    }

    public void setData(uploadFile  file) {
        this.file = file;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(String downloadDate) {
        this.downloadDate = downloadDate;
    }
}
