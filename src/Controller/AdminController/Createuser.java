package Controller.AdminController;

import Bean.users.StudentEntity;
import Bean.users.TeacherEntity;
import Dao.BaseDao;
import Util.HibernateUtil;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Feng on 4/15/16.
 */
@WebServlet(name = "Createuser")
public class Createuser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            /*
            * 创建规则
            * 先根据request 中传入的userType 类型判断生成的用户类型,student/teacher
            * 2.根据 表单中上传的用户数据 填充详细信息 jsp/html 中表单中的name/id 属性要和我写KEY一样,value值用符合  VALUE 的格式
            *  对应信息
            *  ***********************************************************************************************************************************
            *  ***    KEY        VALUE                 TYPE               WARMING
            *  ***   userType    student/teacher       String              不能为空
            *  ***   userID     2213XXXXX/2210XXXXX    int/Integer         不能为空,学生为学号2213开头   教师为2201 开头 长度为 9位,用js 只输入数字
            *  ***   userName   用户姓名                String              输入格式为中文/英文  不允许特殊字符(客户端检查)
            *  ***   userSex    男/女                  String              性别使用 select-option 选择,最好不要用输入(不考虑第三性别)
            *  ***   colleage;  学院                   String              默认使用软件学院
            *  ***   password;                        String              密码长度为 6 -11位 如果为空的话,默认为 123456
            *  ***   birthDate;  yyyy-MM-dd           java.sql.Date       注意 java.util.Date 和 时间格式
            *  ***   cellPhone;  13110518698          long                手机不校验格式, 长度为 11 位
            *  ***   email       abc@abc.com          String              正则表达式校验格式
            *  ***   address;    XXXXXXXXXX           String              地址数据库不校验,建议使用select-option 选择前面的国家省份,地市,再填写详细地址
            ***************************************************************************************************************************************         */
        String userType = request.getParameter("userType");
        //填充详细信息
        // 获取ID
        Integer userID = Integer.parseInt(request.getParameter("userID"));
        //  获取用户名
        String userName = request.getParameter("userName");
        //获取用户性别
        String userSex = request.getParameter("userSex");
        //获取用户学院
        String colleage = request.getParameter("colleage");
        // 获取用户密码
        String password = request.getParameter("password");
        // 获取用户出生日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date =  new Date(new java.util.Date(request.getParameter("birthDate")).getTime());
        //获取用户电话
        String cellPhone =  request.getParameter("cellPhone");
        //获取用户电话
        String email = request.getParameter("email");
        // 获取用户电话
        String address = request.getParameter("address");
        Date createDate = new Date(new java.util.Date().getTime());

        if (userType.equals("student")){

            //创建学生对象
            BaseDao<StudentEntity> studentDao = new BaseDao<StudentEntity>();
            StudentEntity  student = new StudentEntity();



            // 判断空数据,如果为空数据使用默认数据或跳过设置
            if(userID == null){
                throw new NullPointerException("用户ID 不能为null");
            }
            if (userName != null){
                student.setName(userName);
            }
            if (userSex !=null){
                student.setSex(userSex);
            }
            if (colleage != null){
                student.setColleage(colleage);
            }
            if (password !=null){
                student.setPassword(password);
            }
            else {
                student.setPassword("123456");
            }
            if (date !=null){
                student.setBirthDate(date);
            }
            if (cellPhone != null){
                student.setCellPhone(cellPhone);
            }
            if (address!= null){
                student.setAddress(address);
            }
            // 写入数据库
            Session session = HibernateUtil.getInstanceFactory().openSession();
            try{
                session.getTransaction().begin();
                session.persist(student);
                session.getTransaction().commit();
            }catch (Exception e){
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
        if (userType.equals("teacher")){

            //创建学生对象
            BaseDao<TeacherEntity> teacherDao = new BaseDao<TeacherEntity>();
            TeacherEntity  teacher = new TeacherEntity();
            // 判断空数据,如果为空数据使用默认数据或跳过设置
            if(userID == null){
                throw new NullPointerException("用户ID 不能为null");
            }
            if (userName != null){
                teacher.setName(userName);
            }
            if (userSex !=null){
                teacher.setSex(userSex);
            }
            if (colleage != null){
                teacher.setColleage(colleage);
            }
            if (password !=null){
                teacher.setPassword(password);
            }
            else {
                teacher.setPassword("123456");
            }
            if (date !=null){
                teacher.setBirthDate(date);
            }
            if (cellPhone != null){
                teacher.setCellPhone(cellPhone);
            }
            if (address!= null){
                teacher.setAddress(address);
            }
            // 写入数据库
            Session session = HibernateUtil.getInstanceFactory().openSession();
            try{
                session.getTransaction().begin();
                session.persist(teacher);
                session.getTransaction().commit();
            }catch (Exception e){
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
