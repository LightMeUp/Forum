package com.SE3Forum.fzu.Controller;

import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Dao.UserDao;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Feng on 6/23/16.
 */
@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String count =request.getParameter("count");
        String Contact= request.getParameter("contact");
        String verifyCode = request.getParameter("verifycode");

        System.out.println(count+Contact+verifyCode);

        Writer out = response.getWriter();
        if (isRightCount(count,out)){
            List<UserCount> userCountSet = new UserCountService().listAllService();
            for (UserCount userCount:userCountSet){
                if ((userCount.getId() == Integer.parseInt(count))){
                    out.write("<script> alert('账号已经注册请直接登录')</script>");
                }
            }

        }
        else if (!isRight(Contact)) out.write("<script> alert('无效的联系方式')</script>");
        else if (!verifyCode.equals("123456")) out.write("<script> alert('验证码错误')</script>");
        else{
            UserCount userCount = new UserCount();
            userCount.setId(Integer.parseInt(count));
            userCount.setLastLoginDate(Utils.getCurrentDate());
            userCount.setName("未设置");
            if (isMobile(Contact))
                userCount.setCellPhone(Contact);
            else userCount.setEmail(Contact);
            userCount.setPassword("123456");
            userCount.setSecurityToken(Utils.getSecurityToken());
            new UserCountService().addService(userCount);
            User user = new User();
            user.setId(Integer.parseInt(count));
            user.setUserCount(userCount);
            new UserDao().add(user);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    private boolean isRightCount(String count,Writer out) throws IOException {
        if(!count.substring(0,4).equals("2213") &&!count.substring(0,4).equals("2201"))
        {
            out.write("<script>alert('无效的账号,学号为2213开头,教师为2201开头')</script>");
            return false;
        }

        return true;
    }
    private boolean isRight(String contact){
        try{
            if (contact.length() <11)return false;
            int mobile = Integer.parseInt(contact);
        }catch (Exception e){
            System.out.println("not a mobile");
            Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
            Matcher matcher = pattern.matcher(contact);
            if (!matcher.matches())
                return false;
        }
        return true;
    }
    private boolean isMobile(String contact){
        try{
            int mobile = Integer.parseInt(contact);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
