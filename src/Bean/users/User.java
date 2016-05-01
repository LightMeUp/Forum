package Bean.users;

import Bean.Data.Data;
import Bean.Data.downloadRecord;
import Bean.Data.uploadRecord;
import Bean.Post_Comments.Comment;
import Bean.Post_Comments.Post;
import com.sun.tools.javac.code.Types;

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
    // 注册时间
    //最近一次登陆时间
    //发表的帖子
    //评论
    // 权限表
    // 管理其它用户权限(对用户进行增 删 改 查)
    // 发布管理通知
    // 删除贴和评论  (对评论和帖子进行 增 删 改 查)
    // 下载记录
    // 上传记录
    protected int id;                 //账号
    protected String name;            //姓名
    protected String sex;             //性别
    protected String colleage;        //学院
    protected String password;        //密码
    protected Date birthDate;         //出生日期
    protected String cellPhone;       //电话
    protected String email;           //邮箱
    protected String address;      // 地址
    protected Date createdDate;    // 创建日期
    protected Date lastLoginDate;  // 最近一次登陆信息
    protected List<Comment> comments;   //评论
    protected List<Post> posts;   // 发布的帖子
    protected List<downloadRecord> downloadRecords; // 下载记录
    protected List<uploadRecord> uploadRecords; // 上传记录
    protected List<User> friends; // 好友
    protected List<Data> datas;
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
    public Date getLastLoginDate() {
        return lastLoginDate;
    }
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Column(name = "comments")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    @OneToMany(fetch = FetchType.LAZY)
    public List<User> getFriends() {
        return friends;
    }
    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @Column(name = "createdDate")
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "downloadRecords")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    public List<downloadRecord> getDownloadRecords() {
        return downloadRecords;
    }
    public void setDownloadRecords(List<downloadRecord> downloadRecords) {
        this.downloadRecords = downloadRecords;
    }

    @Column(name = "uploadRecords")
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

    @OneToMany(fetch = FetchType.LAZY)
    public List<Data> getDatas() {
        return datas;
    }
    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }
}
