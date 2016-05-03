package Bean.Data;

import Bean.users.User;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Feng on 4/25/16.
 */
@Entity
@Table(name = "uploadingRecord",schema = "ForumDataBase")
public class uploadRecord {

    private int id;
    private User user;
    private Date uploadDate;
    private Files file;
    public Date getUploadDate() {
        return uploadDate;
    }
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public User getUser() {return user;}
    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    public Files getFile() {return file;}

    public void setFile(Files file) {this.file = file;}
}
