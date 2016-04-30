package Bean.Data;

import Bean.users.UserEntity;

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
    private Data data;
    // 下载用户
    private  UserEntity userEntity;
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
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }
}
