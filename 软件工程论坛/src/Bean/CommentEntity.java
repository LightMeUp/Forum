package Bean;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

/**
 * Created by Feng on 3/30/16.
 */
@Entity
@Table(name = "Comment",schema = "UserDataBase")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  tag;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private UserEntity userEntity;





}
