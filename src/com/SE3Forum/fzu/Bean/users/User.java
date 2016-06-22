package com.SE3Forum.fzu.Bean.users;
import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    protected Set<Post> posts;   //评论
    protected Set<Topic> topics;   // 发布的帖子
    protected Set<UserCount> friends; // 好友
    protected Set<uploadFile> files;
    //权限管理
    protected UserCount userCount;

    @Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn
    public UserCount getUserCount() {
        return userCount;
    }

    public void setUserCount(UserCount userCount) {
        this.userCount = userCount;
    }

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }
    @ManyToMany(fetch = FetchType.EAGER)
    public Set<UserCount> getFriends() {
        return friends;
    }

    public void setFriends(Set<UserCount> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    public Set<uploadFile> getFiles() {
        return files;
    }

    public void setFiles(Set<uploadFile> files) {
        this.files = files;
    }

}
