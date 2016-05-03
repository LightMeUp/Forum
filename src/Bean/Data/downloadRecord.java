package Bean.Data;

import Bean.users.User;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Feng on 4/25/16.
 */
@Entity
@Table(name = "downloadrecord",schema = "ForumDataBase")
public class downloadRecord {
    // 下载记录编号
    private int id;
    // 资料
    private Files file;
    // 下载用户
    private  User user;
    // 下载日期
    private Date downloadDate;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    public Files getData() {
        return file;
    }

    public void setData(Files file) {
        this.file = file;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }
}
