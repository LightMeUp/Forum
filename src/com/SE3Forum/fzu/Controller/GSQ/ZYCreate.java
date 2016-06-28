package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.ITeacherService;
import com.SE3Forum.fzu.Service.SchoolAssignmentService;
import com.SE3Forum.fzu.Service.TeacherService;
import com.SE3Forum.fzu.Service.TopicService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * Created by zhu on 2016/6/23.
 */
public class ZYCreate extends ActionSupport{
    private int id;
    private String content;
    private String year;
    private String month;
    private String day;

    @Override
    public String execute() throws Exception {
        String limitDate = year+"-"+month+"-"+day+" 00:00:00";
        Date date = Utils.parseStringToDate(limitDate);
        System.out.println("截止日期:"+date);
        HttpServletRequest request = ServletActionContext.getRequest();

        UserCount userCount = (UserCount) request.getSession().getAttribute("user");

        Teacher teacher = new TeacherService().findService(Teacher.class,userCount.getId());
        SchoolAssignment schoolAssignment=new SchoolAssignment();
        SchoolAssignmentService schoolAssignmentService=new SchoolAssignmentService();
        schoolAssignment.setPublishDate(Utils.getCurrentDate());
        schoolAssignment.setContent(content);
        schoolAssignment.setDeadLine(date);
        schoolAssignment.setAssignmentNumbers(0);
        schoolAssignment.setTeacher(teacher);
       schoolAssignmentService.addService(schoolAssignment);


        // 教师表中添加作业

        Set<SchoolAssignment> schoolAssignmentList = teacher.getSchoolAssignments();
        if (schoolAssignmentList==null)
            schoolAssignmentList = new HashSet<>();
        schoolAssignmentList.add(schoolAssignment);
        teacher.setSchoolAssignments(schoolAssignmentList);
        new TeacherService().updateServcie(teacher);
        Topic topic = new Topic();
        topic.setTheme("软件工程第X次作业发布");
        topic.setContent("软件工程第X次作业已经发布,请进入我的课程查看");
        topic.setCreateDate(Utils.getCurrentDate());
        topic.setLastUpdateDate(Utils.getCurrentDate());
        topic.setUser(userCount);
        topic.setType("Notification");
        topic.setOnTop(1);
        new TopicService().addService(topic);
        request.setAttribute("ZY",new SchoolAssignmentService().listAllService("schoolAssignment"));

        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
