package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Dao.StudentDao;
import com.SE3Forum.fzu.Service.EvaluationService;
import com.SE3Forum.fzu.Service.SchoolAssignmentService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by zhu on 2016/6/23.
 */
public class ZYUpload extends ActionSupport{
    private int schoolAssignmentId;
    private String content;
    @Override
    public String execute() throws Exception {

        System.out.println(""+schoolAssignmentId+content);
        HttpServletRequest request = ServletActionContext.getRequest();
        SchoolAssignmentService schoolAssignmentService=new SchoolAssignmentService();
        SchoolAssignment schoolAssignment=schoolAssignmentService.findService(SchoolAssignment.class,schoolAssignmentId);


        //检查作业是否提交,如果已经提交 就对内容进行修改
        // 提交作业的学生

       UserCount userCount =(UserCount) request.getSession().getAttribute("user");
        Student student = (Student)new StudentDao().find(Student.class,userCount.getId());
        Evaluation evaluation=new Evaluation();
        int index=0;
        if (Utils.isAssignmentSubmitted(schoolAssignmentId,student)){
            evaluation =getEvaluation(student,schoolAssignmentId);
            List<Evaluation> evaluations = schoolAssignment.getEvaluations();
            for (int i=0;i<evaluations.size();i++){
                if (evaluations.get(i).getId()== evaluation.getId())
                    index=i;break;
            }
            System.out.println("修改"+index);

            //  先从学生表中删除
            Set<Evaluation> studentEvaluation = student.getEvaluations();
            studentEvaluation.remove(evaluation);

            evaluation.setContent(content);
            evaluation.setSubmitDate( Utils.getCurrentDate());
            new EvaluationService().updateServcie(evaluation);
            // 作业表中添加该学生的上交作业

            evaluations.set(index,evaluation);
            schoolAssignment.setEvaluations(evaluations);
            new SchoolAssignmentService().updateServcie(schoolAssignment);
            //update student table

            studentEvaluation.add(evaluation);
            student.setEvaluations(studentEvaluation);
        }
        else {
                System.out.println("create");

            // 创建一个成绩表格

            // submit date
            evaluation.setSubmitDate(Utils.getCurrentDate());
            evaluation.setContent(content);
            //submit student
            evaluation.setStudent(student);
            //set schoolassignment
            evaluation.setSchoolAssignment(schoolAssignment);

            evaluation.setEvaluate("未评价");
            evaluation.setScore(0.0f);
            EvaluationService evaluationService = new EvaluationService();
            evaluationService.addService(evaluation);


            // 作业表中添加该学生的上交作业
            List<Evaluation> evaluations = schoolAssignment.getEvaluations();
            if (evaluations == null)
                evaluations = new ArrayList<>();
            evaluations.add(evaluation);
            schoolAssignment.setEvaluations(evaluations);
            schoolAssignment.setAssignmentNumbers(schoolAssignment.getAssignmentNumbers()+1);
            new SchoolAssignmentService().updateServcie(schoolAssignment);


            //update student table
            Set<Evaluation> studentEvaluation = student.getEvaluations();
            if (studentEvaluation == null) studentEvaluation = new HashSet<>();
            studentEvaluation.add(evaluation);
            student.setEvaluations(studentEvaluation);
        }
        new StudentDao().update(student);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.sendRedirect("/ZYShow");
        return null;
    }

    public int getSchoolAssignmentId() {
        return schoolAssignmentId;
    }

    public void setSchoolAssignmentId(int schoolAssignmentId) {
        this.schoolAssignmentId = schoolAssignmentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Evaluation getEvaluation(Student student, int id){
        Set<Evaluation> evaluations = student.getEvaluations();
        for (Evaluation evaluation:evaluations){
            if (evaluation.getSchoolAssignment().getId()==id)
                return evaluation;
        }
        return null;
    }
}
