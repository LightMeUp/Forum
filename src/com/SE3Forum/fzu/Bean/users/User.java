package com.SE3Forum.fzu.Bean.users;
import com.SE3Forum.fzu.Bean.Data.downloadRecord;
import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.Data.uploadRecord;
import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 3/30/16.
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User {
    //发表的帖子
    //评论
    // 管理其它用户权限(对用户进行增 删 改 查)
    // 删除贴和评论  (对评论和帖子进行 增 删 改 查)
    // 下载记录
    // 上传记录
    protected int id;                 //账号
    protected List<Post> posts;   //评论
    protected List<Topic> topics;   // 发布的帖子
    protected List<downloadRecord> downloadRecords; // 下载记录
    protected List<uploadRecord> uploadRecords; // 上传记录
    protected List<User> friends; // 好友
    protected List<uploadFile> files;
    //权限管理

    @Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "user")
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    @OneToMany(mappedBy = "user")
    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
    @OneToMany(mappedBy = "user")
    public List<downloadRecord> getDownloadRecords() {
        return downloadRecords;
    }

    public void setDownloadRecords(List<downloadRecord> downloadRecords) {
        this.downloadRecords = downloadRecords;
    }

    @OneToMany(mappedBy = "user")
    public List<uploadRecord> getUploadRecords() {
        return uploadRecords;
    }

    public void setUploadRecords(List<uploadRecord> uploadRecords) {
        this.uploadRecords = uploadRecords;
    }

    @ManyToMany
    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "user")
    public List<uploadFile> getFiles() {
        return files;
    }

    public void setFiles(List<uploadFile> files) {
        this.files = files;
    }

}
