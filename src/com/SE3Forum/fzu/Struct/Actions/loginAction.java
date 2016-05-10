package com.SE3Forum.fzu.Struct.Actions;

import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Dao.StudentDao;
import com.SE3Forum.fzu.Dao.TeacherDao;
import com.SE3Forum.fzu.Struct.FormBeans.loginFormBean;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            System.out.println(loginForm.getUserType());
            if (loginForm.getUserType().equals("student")){
                StudentDao studentDao = new StudentDao();
                Student student = (Student) studentDao.find(Student.class,Integer.parseInt(loginForm.getId()));
                if (student !=null && student.getPassword().equals(loginForm.getPassword())){
                    request.setAttribute("user",loginForm);
                    return mapping.findForward("success");
                }
                else {
                    return mapping.getInputForward();
                }
            }
            else {
                TeacherDao teacherDao =new TeacherDao();
                Teacher teacher = (Teacher) teacherDao.find(Teacher.class,Integer.parseInt(loginForm.getId()));
                if (teacher !=null && teacher.getPassword().equals(loginForm.getPassword())){
                    request.setAttribute("user",loginForm);
                    return mapping.findForward("success");
                }
                else {
                    return mapping.getInputForward();
                }
            }

        }
    }
}
