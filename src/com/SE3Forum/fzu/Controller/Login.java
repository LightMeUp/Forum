package com.SE3Forum.fzu.Controller;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Dao.StudentDao;
import com.SE3Forum.fzu.Dao.TeacherDao;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import com.SE3Forum.fzu.Exception.UserNotFoundException;
import com.SE3Forum.fzu.Util.Utils;

/**
 * Created by Feng on 3/31/16.
 */
public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws  javax.servlet.ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        boolean tf = true;

        // 获取账号
        String count = request.getParameter("count");
        //获取密码
        String pwd = request.getParameter("password");
        //获取用户类型
        String userType = request.getParameter("userType");
        // 是否保存登陆信息,持久登陆
        String loginType = request.getParameter("loginOption");
        System.out.println("count:"+count+"password:"+pwd +"userType"+userType+"loginOption:"+loginType);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }

}
