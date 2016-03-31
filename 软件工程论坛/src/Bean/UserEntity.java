package Bean;

import javax.persistence.*;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Feng on 3/30/16.
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class UserEntity {
     // 账号   学生为学号  老师为教工号    管理员为 admin
    // 姓名
    // 性别
    // 学院
    //专业
    // 班级   学生有  教师和管理员没有
    //密码     管理员为admin
    // 昵称
    // 联系方式,电话,邮箱
    // 注册时间
    //最近一次登陆时间
    //老师   学生类有
    //发表的帖子
    //评论
    //
    protected int id;                 //账号
    protected String name;            //姓名
    protected String sex;             //性别
    protected byte[]  image;          //头像
    protected String colleage;        //学院
    protected String password;        //密码
    protected String nickname;        //昵称
    protected Date birthDate;         //出生日期
    protected String cellPhone;       //电话
    protected String email;           //邮箱
    protected String address;      // 地址
    protected Date lastLoginDate;  // 最近一次登陆信息
    protected List<CommentEntity> commentEntities;   //评论
    protected List<PostEntity> postEntities;   // 发布的帖子



    //权限管理
    protected int downloadAuthority = 1;    //  学生老师都有下载的权限
    protected int uploadAuthority   = 1;    // 学生老师都有上传的权限.根据不同的内容进行选择
    protected int publishAuthority  = 1;    // 学生老师都有发表评论的权限
    protected int adminAuthority ;    //学生类没有管理的权限

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    @Column(name = "colleage")
    public String getColleage() {
        return colleage;
    }

    public void setColleage(String colleage) {
        this.colleage = colleage;
    }
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    @Column(name = "birthdate")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    @Column(name = "cellphone")
    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "lastlogindate")
    public Date getLastLoginDate() {
        return lastLoginDate;
    }
    @Column(name = "comments")
    @OneToMany
    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }
    @Column(name = "posts")
    @OneToMany
    public List<PostEntity> getPostEntities() {
        return postEntities;
    }

    public void setPostEntities(List<PostEntity> postEntities) {
        this.postEntities = postEntities;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    @Column(name = "downloadauthority")
    public int getDownloadAuthority() {
        return downloadAuthority;
    }

    public void setDownloadAuthority(int downloadAuthority) {
        this.downloadAuthority = downloadAuthority;
    }
    @Column(name = "uploadauthority")
    public int getUploadAuthority() {
        return uploadAuthority;
    }

    public void setUploadAuthority(int uploadAuthority) {
        this.uploadAuthority = uploadAuthority;
    }
    @Column(name = "publishauthority")
    public int getPublishAuthority() {
        return publishAuthority;
    }

    public void setPublishAuthority(int publishAuthority) {
        this.publishAuthority = publishAuthority;
    }
    @Column(name = "adminauthority")
    public int getAdminAuthority() {
        return adminAuthority;
    }

    public void setAdminAuthority(int adminAuthority) {
        this.adminAuthority = adminAuthority;
    }

}
