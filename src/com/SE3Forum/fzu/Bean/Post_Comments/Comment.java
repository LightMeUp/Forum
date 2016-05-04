package com.SE3Forum.fzu.Bean.Post_Comments;

import com.SE3Forum.fzu.Bean.users.User;

import javax.persistence.*;

/**
 * Created by Feng on 3/30/16.
 */
@Entity
@Table(name = "Comment",schema = "ForumDataBase")
public class Comment {

    private Integer id;
    private String  tag;
    private String content;
    private User user;
    private Post post;

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
    @JoinColumn(name = "post_id")
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
