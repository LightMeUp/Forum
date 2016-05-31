package com.SE3Forum.fzu.Bean.Post_Comments;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Feng on 3/30/16.
 */

    /*
    * 用户发帖
    * 帖子ID
    * 帖子类型
    * 帖子内容
    * 帖子评论   一篇帖子可有多个评论*/
@Entity
@Table(name = "Topic",schema = "ForumDataBase")
public class Topic {

    private int id;

    // 主题的标题
    private String Theme;

    //主题文字内容
    private String Content;

    //发帖用户
    private UserCount user;

    // 帖子类型
    private String type;

    // 主题中发布的帖子
    private List<Post>posts;

    // 主题的图片内容, 可以没有
    private List<image> images;

    // 主题是否置顶   用 0 1 表示   0 表示不置顶 1表示置顶
    private int OnTop;

    // 创建日期
    private String createDate;

    // 最后一次修改时间
    private String lastUpdateDate;

    // files
    private List<uploadFile> files;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public UserCount getUser() {
        return user;
    }

    public void setUser(UserCount userEntity) {
        this.user = userEntity;
    }

    @OneToMany
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @OneToMany
    public List<image> getImages() {
        return images;
    }

    public void setImages(List<image> images) {
        this.images = images;
    }

    public int getOnTop() {
        return OnTop;
    }

    public void setOnTop(int onTop) {
        OnTop = onTop;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @OneToMany
    public List<uploadFile> getFiles() {
        return files;
    }

    public void setFiles(List<uploadFile> files) {
        this.files = files;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
