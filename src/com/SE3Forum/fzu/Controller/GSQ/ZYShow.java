package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Dao.StudentDao;
import com.SE3Forum.fzu.Service.IStudentService;
import com.SE3Forum.fzu.Service.SchoolAssignmentService;
import com.SE3Forum.fzu.Service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhu on 2016/6/25.
 */
public class ZYShow extends ActionSupport {

    @Override
    public String execute() throws Exception {
        HttpServletRequest request= ServletActionContext.getRequest();
        UserCount userCount = (UserCount)request.getSession().getAttribute("user");
        Student student =(Student) new StudentDao().find(Student.class,userCount.getId());

        SchoolAssignmentService schoolAssignmenrtSevice=new SchoolAssignmentService();
        List<SchoolAssignment> schoolAssignments =schoolAssignmenrtSevice.findAssignmentWithTeacherId(student.getTeacher().getId());
        request.setAttribute("ZY",schoolAssignments);

        return SUCCESS;
    }

}
