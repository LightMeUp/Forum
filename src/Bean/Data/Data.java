package Bean.Data;

import Bean.users.UserEntity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Feng on 4/25/16.
 */
/* 用户上传资料数据库只保存文件名,文件具体的存放 改为存放在服务器硬盘下
*  优点1. 数据加载速度快,如果以二进制数据存放在数据库内,数据加载时间过长
*  优点2. 数据不易发生错误
*  优点3. 用户上传一张图片需要对图片进行多种处理,使用数据库不易操作*/

@Entity
@Table(name = "data",schema = "ForumDataBase")
public class Data {
    // 上传资料编号
    private int id;
    // 保存文件名
    private String FileName;
    // 上传用户
    private UserEntity userEntity;
    //上传日期
    private Date uploadingDate;
    // 有效时间
    private Date validateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "filename")
    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }
    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    @Column(name = "uploadingdate")
    public Date getUploadingDate() {
        return uploadingDate;
    }
    public void setUploadingDate(Date uploadingDate) {
        this.uploadingDate = uploadingDate;
    }
    @Column(name = "validatedate")
    public Date getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(Date validateDate) {
        this.validateDate = validateDate;
    }
}