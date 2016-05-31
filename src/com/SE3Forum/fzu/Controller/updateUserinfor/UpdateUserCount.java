package com.SE3Forum.fzu.Controller.updateUserinfor;

import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 * Created by Feng on 5/25/16.
 */
public class UpdateUserCount  extends ActionSupport{

    private String name;            //姓名
    private String sex;             //性别
    private String headimage;          // 头像
    private String password;        //密码
    private Date  birthDate;         //出生日期
    private String qqnumber;         // QQ联系
    private String cellPhone;       //电话
    private String email;             //邮箱
    private String  origin;           //籍贯
    private String address;      // 地址


    public String execute(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

                // 判断是否登录
        if (Utils.isLogin(request.getCookies())){
            String userId="";
            for (Cookie cookie:request.getCookies()){
                if (cookie.getName().equals("count")){
                    userId = cookie.getValue();
                }
            }
            UserCount  userCount =  new UserCountService().findService(Integer.parseInt(userId));
            userCount.setName(name);
            userCount.setAddress(address);
            userCount.setSex(sex);
            userCount.setHeadimage(headimage);
            userCount.setPassword(password);
            userCount.setBirthDate(birthDate);
            userCount.setQqnumber(qqnumber);
            userCount.setCellPhone(cellPhone);
            userCount.setEmail(email);
            userCount.setOrigin(origin);
            new UserCountService().updateServcie(userCount);
            return SUCCESS;
        }
        // 用户没有登录,返回错误;
        return ERROR;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        this.password = password;
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
}
