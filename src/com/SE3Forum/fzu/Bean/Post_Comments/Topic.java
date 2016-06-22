package com.SE3Forum.fzu.Bean.Post_Comments;
import com.SE3Forum.fzu.Bean.users.UserCount;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    private Set<Post> posts;

    // 主题是否置顶   用 0 1 表示   0 表示不置顶 1表示置顶
    private int OnTop;

    // 创建日期
    private Date createDate;

    // 最后一次修改时间
    private String lastUpdateDate;



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

    @OneToMany(mappedBy = "topic")
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }


    public int getOnTop() {
        return OnTop;
    }

    public void setOnTop(int onTop) {
        OnTop = onTop;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
