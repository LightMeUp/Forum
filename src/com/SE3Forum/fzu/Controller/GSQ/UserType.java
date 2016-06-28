package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.users.UserCount;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhu on 2016/6/23.
 */
public class UserType  extends ActionSupport{
    @Override
    public String execute() throws Exception {
        String userId="";
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies= request.getCookies();
        HttpSession session = request.getSession();
        UserCount userCount= (UserCount) session.getAttribute("user");
        if(userCount == null){
            System.out.println("not login yet");
            return ERROR;
        }
        System.out.print(userCount.getUserType());
        if (userCount.getUserType().equals("Teacher")){
            return "teacher";
        }

        return "student";

    }
}
