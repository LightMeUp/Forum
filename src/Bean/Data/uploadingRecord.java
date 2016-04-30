package Bean.Data;

import Bean.users.UserEntity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Feng on 4/25/16.
 */
@Entity
@Table(name = "uploadingRecord",schema = "ForumDataBase")
public class uploadingRecord {
    @Id
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity userEntity;
    private Date uploadDate;

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
