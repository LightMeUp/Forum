package com.SE3Forum.fzu.Bean.SchoolAssignment;

import com.SE3Forum.fzu.Bean.users.Student;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Feng on 4/14/16.
 */
/*
* 作业评价表
* */


@Entity
@Table(name = "evaluation",schema = "ForumDatabase")
public class Evaluation {

    // 编号
    private int id;

    // 属于的作业
    private SchoolAssignment schoolAssignment;

    // 提交作业的学生
    private Student student;

    //学生作业提交时间
    private Date submitDate;

    // 作业得分
    private float score;

    // 教师评语
    private String Evaluate;
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assignment_id")

    public SchoolAssignment getSchoolAssignment() {
        return schoolAssignment;
    }
    public void setSchoolAssignment(SchoolAssignment schoolAssignment) {
        this.schoolAssignment = schoolAssignment;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student= student;
    }

    public Date getCreatedDate() {
        return submitDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.submitDate = createdDate;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getEvaluate() {
        return Evaluate;
    }

    public void setEvaluate(String evaluate) {
        Evaluate = evaluate;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
