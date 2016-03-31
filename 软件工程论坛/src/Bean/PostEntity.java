package Bean;

import com.sun.xml.internal.ws.api.FeatureConstructor;
import org.hibernate.annotations.Fetch;

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
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity userEntity;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "post id")
    private List<CommentEntity>commentEntities;
}
