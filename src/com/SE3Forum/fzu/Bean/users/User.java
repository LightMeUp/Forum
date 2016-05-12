package com.SE3Forum.fzu.Bean.users;
import com.SE3Forum.fzu.Bean.Data.downloadRecord;
import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.Data.uploadRecord;
import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 3/30/16.
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User {
     // 账号   学生为学号  老师为教工号    管理员为 admin
    // 姓名
    // 性别
    // 学院
    //专业
    // 班级   学生有  教师和管理员没有
    //密码     管理员为admin
    // 昵称
    // 联系方式,电话,邮箱
    //最近一次登陆时间
    //发表的帖子
    //评论
    // 权限表
    // 管理其它用户权限(对用户进行增 删 改 查)
    // 删除贴和评论  (对评论和帖子进行 增 删 改 查)
    // 下载记录
    // 上传记录
    protected int id;                 //账号
    protected String name;            //姓名
    protected String sex;             //性别
    protected String headimage;          // 头像
    protected String password;        //密码
    protected Date birthDate;         //出生日期
    protected String qqnumber;         // QQ联系
    protected String cellPhone;       //电话
    protected String email;             //邮箱
    protected String  origin;           //籍贯
    protected String address;      // 地址
    protected String lastLoginDate;  // 最近一次登陆信息
    protected List<Post> posts;   //评论
    protected List<Topic> topics;   // 发布的帖子
    protected List<downloadRecord> downloadRecords; // 下载记录
    protected List<uploadRecord> uploadRecords; // 上传记录
    protected List<User> friends; // 好友
    protected List<uploadFile> files;
    protected String SecurityToken;
    //权限管理

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

    public String getQqnumber() {
        return qqnumber;
    }

    public void setQqnumber(String qqnumber) {
        this.qqnumber = qqnumber;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "birthdate")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    @Column(name = "cellphone",unique = true)
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
    public String getLastLoginDate() {
        return lastLoginDate;
    }
    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }


    @OneToMany(fetch = FetchType.LAZY)
    public List<User> getFriends() {
        return friends;
    }
    public void setFriends(List<User> friends) {
        this.friends = friends;
    }


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    public List<downloadRecord> getDownloadRecords() {
        return downloadRecords;
    }
    public void setDownloadRecords(List<downloadRecord> downloadRecords) {
        this.downloadRecords = downloadRecords;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    public List<uploadRecord> getUploadRecords() {
        return uploadRecords;
    }
    public void setUploadRecords(List<uploadRecord> uploadRecords) {this.uploadRecords = uploadRecords;}

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    public List<Post> getPosts() {
        return posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    public List<uploadFile> getFiles() {return files;}
    public void setFiles(List<uploadFile> files) {this.files = files;}

    public String getSecurityToken() {
        return SecurityToken;
    }
    public void setSecurityToken(String securityToken) {
        SecurityToken = securityToken;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Column(name = "headimage")
    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }
}
