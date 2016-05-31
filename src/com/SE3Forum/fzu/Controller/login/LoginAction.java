package com.SE3Forum.fzu.Controller.login;

import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Feng on 5/24/16.
 */
public class LoginAction extends ActionSupport {
    private String count;
    private String password;

    public String execute(){
        System.out.println("count "+count);
        System.out.println("count "+password);
        UserCountService service = new UserCountService();
         UserCount user = service.findService(Integer.parseInt(count));
        if (user == null){

            // 帐号不存在,返回错误
            System.out.println("该用户不存在");
            return "error";
        }
        else{
            if (!user.getPassword().equals(password)){
                //  用户密码错误
                System.out.println("wrong password");
                return "error";
            }
        }
        /*将用户的 用户头像,用户名,帐号,安全码,登录状态 保存在Cookie中*/
        // 获取用户头像路径

        // 设置Cookie
        Cookie countCookie = new Cookie("count",""+user.getId());
        Cookie securityTokenCookie = new Cookie("sercurityToken",user.getSecurityToken());

        // 获取request 和response
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();

        // 获取session
        HttpSession session = request.getSession();
        // 添加Cookie
        response.addCookie(countCookie);
        response.addCookie(securityTokenCookie);
        session.setAttribute("user",user);
            // 信息验证通过
        return SUCCESS;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
