package com.SE3Forum.fzu.Bean.Post_Comments;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Feng on 3/30/16.
 */
@Entity
@Table(name = "post",schema = "ForumDataBase")
public class Post {

    // 帖子编号
    private Integer id;
    private String  tag;

    // 帖子内容
    private String content;

    //发帖用户
    private UserCount user;

    // 发帖所属于的主题
    private Topic topic;

    private Date createDate;

    private int Ontop;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    public UserCount getUser() {return user;}
    public void setUser(UserCount user) {
        this.user = user;
    }

    @ManyToOne(fetch =  FetchType.EAGER)
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic post) {
        this.topic = post;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public int getOntop() {
        return Ontop;
    }

    public void setOntop(int ontop) {
        Ontop = ontop;
    }

}
