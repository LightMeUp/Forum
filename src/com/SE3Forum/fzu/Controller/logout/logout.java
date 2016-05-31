package com.SE3Forum.fzu.Controller.logout;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Feng on 5/25/16.
 */
public class logout extends ActionSupport {
    public String execute(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        Cookie loginstate = new Cookie("isLogin","NO");
        loginstate.setPath("/cookies");
        response.addCookie(loginstate);
        request.setAttribute("isLogin","NO");
        for (Cookie cookie:request.getCookies()){
            Cookie cookie1 = new Cookie(cookie.getName(),"null");
            cookie1.setPath("/cookies");
            cookie1.setMaxAge(0);
            response.addCookie(cookie1);
        }
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        return SUCCESS;


    }
}
