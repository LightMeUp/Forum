package Bean.Post_Comments;

import Bean.Post_Comments.CommentEntity;
import Bean.users.UserEntity;

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
@Table(name = "post",schema = "UserDataBase")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Theme;
    private String Content;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(fetch = FetchType.EAGER)
    private List<CommentEntity>commentEntities;


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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }
}
