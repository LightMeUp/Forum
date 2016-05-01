package Controller;
import Bean.users.User;
import Bean.users.Student;
import Bean.users.Teacher;
import Dao.StudentDao;
import Dao.TeacherDao;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import Exception.UserNotFoundException;
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
             TeacherDao teacherDao = new TeacherDao();
            Teacher teacher =(Teacher) teacherDao.findEntity(Teacher.class,Integer.parseInt(count));
            tf = checkUserInfor(teacher,pwd);
        }
        // 学生登陆
        if (userType.equals("student")) {
            StudentDao studentDao = new StudentDao();
            Student student = (Student) studentDao.findEntity(Student.class, Integer.parseInt(count));
            tf= checkUserInfor(student,pwd);
        }
        if (tf ==true){
            System.out.println("用户信息正确");
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
        else{
            System.out.println("用户不存在或用户名错误");
            throw  new UserNotFoundException("用户不存在或用户名错误");

        }

    }


    private boolean checkUserInfor(User user,String pwd)
    {
        if(user == null){
            System.out.print("用户不存在");
            return false;
        }
        else if(!user.getPassword().equals(pwd)){
            System.out.print("密码错误");
            return false;
        }
        return true;
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }

}
