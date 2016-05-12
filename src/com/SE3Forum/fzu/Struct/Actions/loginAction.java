package com.SE3Forum.fzu.Struct.Actions;

import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Dao.BaseDao;
import com.SE3Forum.fzu.Dao.StudentDao;
import com.SE3Forum.fzu.Dao.TeacherDao;
import com.SE3Forum.fzu.Service.StudentService;
import com.SE3Forum.fzu.Struct.FormBeans.loginFormBean;
import com.SE3Forum.fzu.Util.HibernateUtil;
import com.SE3Forum.fzu.Util.UserType;
import com.SE3Forum.fzu.Util.Utils;
import org.apache.commons.codec.net.URLCodec;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

/**
 * Created by Feng on 5/5/16.
 */
public class loginAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request,
                                 HttpServletResponse response){
        loginFormBean loginForm = (loginFormBean)form;
        if (loginForm.getId() == null || loginForm.getPassword() ==null){
            return mapping.getInputForward();
        }
        else {
            switch (Utils.getUsertype(loginForm.getId())){
                case  studentType: {
                    StudentService studentService = new StudentService();
                    Student student = studentService.findService(Student.class, Integer.parseInt(loginForm.getId()));
                    if (student != null && student.getPassword().equals(loginForm.getPassword())) {
                        loginForm.setUser(student);
                        System.out.println("登录成功");
                        setSession(student,request,response);
                        return mapping.findForward("success");
                    }
                }
                case TeacherType: {
                    TeacherDao teacherDao = new TeacherDao();
                    Teacher teacher = (Teacher) teacherDao.find(Teacher.class, Integer.parseInt(loginForm.getId()));
                    if (teacher != null && teacher.getPassword().equals(loginForm.getPassword())) {
                        loginForm.setUser(teacher);
                        setSession(teacher,request,response);
                        return mapping.findForward("success");
                    }
                }
                case UnknownType:
                {
                    return mapping.getInputForward();
                }
            }
        }
                return mapping.getInputForward();
    }

    // 根据用户帐号前4位来判定用户类型  2213 为学生类型  2201 为教师类型
    public HttpSession setSession(User user,HttpServletRequest request,HttpServletResponse response){
        HttpSession  session = request.getSession();
        UserType usertype =Utils.getUsertype(""+user.getId());
        String id =""+user.getId();
        String name = user.getName();
        String sex = user.getSex();
        String securityToken = user.getSecurityToken();
        String lastlogin = user.getLastLoginDate()!=null?user.getLastLoginDate(): Utils.getCurrentDate();
        String image = user.getHeadimage()!=null?user.getHeadimage():"";

        session.setAttribute("usertype",usertype);
        session.setAttribute("name",name);
        session.setAttribute("sex",sex);
        session.setAttribute("securityToken",securityToken);
        session.setAttribute("lastlogin",lastlogin);
        session.setAttribute("headerimage",image);

        // 将用户的帐号和SecurityToken保存在 Cookie中
        Cookie idCookie = new Cookie("id",id);
        idCookie.setMaxAge(7*24*60*60);
        // 将安全序列号保存在cookie中
        Cookie securityCookie = new Cookie("securitytoken",securityToken);
        securityCookie.setMaxAge(7*24*60*60);

        Cookie usertypeCookie = new Cookie("usertype",usertype.toString());
        usertypeCookie.setMaxAge(7*24*60*60);

        Cookie lastloginCookie = new Cookie("lastlogin",Utils.getCurrentDate());
        lastloginCookie.setMaxAge(7*24*60*60);

        // imagecookie
        Cookie imageCookie = new Cookie("headimage",user.getHeadimage());
        imageCookie.setMaxAge(7*24*60*60);

        Cookie nameCookie = null;
        try {
            nameCookie = new Cookie("username", URLEncoder.encode(user.getName(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        nameCookie.setMaxAge(7*24*60*60);

        response.addCookie(idCookie);
        response.addCookie(nameCookie);

        response.addCookie(usertypeCookie);

        response.addCookie(lastloginCookie);

        response.addCookie(imageCookie);

        response.addCookie(securityCookie);


        //  修改数据表
        user.setLastLoginDate(Utils.getCurrentDate());
        new BaseDao().update(user);
        HibernateUtil.getSession().close();
        return session;
    }

}
