package Controller;

import Bean.users.StudentEntity;
import Bean.users.TeacherEntity;
import Dao.BaseDao;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Feng on 3/31/16.
 */
public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            this.doPost(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 获取账号
        String count = request.getParameter("count");
        //获取密码
        String pwd = request.getParameter("password");
        //获取用户类型
        String userType = request.getParameter("userType");
        // 是否保存登陆信息,持久登陆
        String loginType = request.getParameter("loginOption");
        HttpSession session = request.getSession();
          // 游客登陆
        if (userType.equals("tourist")){
            // 填充临时session

            String countId  =  "tour" + Util.Utils.getTouristId();
            session.setAttribute("countId",countId);
            session.setAttribute("loginDate",new Date());
            System.out.printf("游客登陆:游客id"+ countId + " 登陆时间:" + session.getAttribute("loginDate"));

            // 跳转到下一个页面
            response.sendRedirect("@NextPage");
        }

        // 教师登陆
        if (userType.equals("teacher")){
            BaseDao<TeacherEntity> teacherDao =  new BaseDao<TeacherEntity>();
            TeacherEntity teacher = (TeacherEntity) teacherDao.findEntity(TeacherEntity.class, Integer.parseInt(count));
            if(teacher == null){
                // 跳转到错误页面
                throw new NullPointerException("没有该账户信息");
            }
            else if(!teacher.getPassword().equals(pwd)){
                System.out.print("密码错误");

                // 跳转到错误页面
                response.sendRedirect("errorPage");
            }
            System.out.printf("教师登陆:教师id"+ count + " 登陆时间:" + session.getAttribute("loginDate"));
        }
        // 学生登陆
        if (userType.equals("student")){
            BaseDao<StudentEntity> studentDao =  new BaseDao<StudentEntity>();
            StudentEntity student = (StudentEntity)studentDao.findEntity(StudentEntity.class, Integer.parseInt(count));
            if(student == null){
                // 跳转到错误页面
                throw new NullPointerException("没有该账户信息");
            }
            else if(!student.getPassword().equals(pwd)){
                System.out.print("密码错误");

                // 跳转到错误页面
                response.sendRedirect("errorPage");
            }
            System.out.printf("教师登陆:教师id"+ count + " 登陆时间:" + session.getAttribute("loginDate"));
        }



        // 保存用户登陆信息
        if (loginType.equals("YES")){
            // 保存用户登陆ID
            session.setAttribute("countId",count);
            // 保存登陆密码
            session.setAttribute("password",pwd);
            // 保存最后登陆时间
            session.setAttribute("loginDate",new Date());
        }

    }


}
