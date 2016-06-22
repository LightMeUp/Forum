package com.SE3Forum.fzu.Bean.users;

import com.SE3Forum.fzu.Util.Utils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Feng on 5/23/16.
 */
@Entity
/*这张表包含所有用户信息,使用userType 区别学生还是用教师*/
public class UserCount {
    protected int id;//账号
    protected String userType;
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
    protected Date lastLoginDate;  // 最近一次登陆信息
    protected String securityToken; // 安全信息码
    protected User user;


    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // 修改密码的同时修改验证码
        this.password = password;
        String securityToken = Utils.getSecurityToken();
        setSecurityToken(securityToken);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getQqnumber() {
        return qqnumber;
    }

    public void setQqnumber(String qqnumber) {
        this.qqnumber = qqnumber;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }
}
