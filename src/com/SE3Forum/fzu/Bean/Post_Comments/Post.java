package com.SE3Forum.fzu.Bean.Post_Comments;

import com.SE3Forum.fzu.Bean.users.User;

import javax.persistence.*;
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
    private User user;

    // 发帖所属于的主题
    private Topic topic;

    // 发帖中包含的图片(可空)
    private Set<image>images;

    private String  createDate;
    private List<Post> posts;

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

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    public User getUser() {return user;}
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch =  FetchType.EAGER)
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic post) {
        this.topic = post;
    }

    @OneToMany()
    public Set<image> getImages() {
        return images;
    }

    public void setImages(Set<image> images) {
        this.images = images;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    @OneToMany
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getOntop() {
        return Ontop;
    }

    public void setOntop(int ontop) {
        Ontop = ontop;
    }
}
