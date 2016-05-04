package com.SE3Forum.fzu.Bean.SchoolAssignment;

import com.SE3Forum.fzu.Bean.users.Student;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Feng on 4/14/16.
 */
@Entity
@Table(name = "evaluation",schema = "ForumDatabase")
public class Evaluation {

    private int id;
    private SchoolAssignment schoolAssignment;
    private Student student;
    private Date createdDate;
    private float score;
    private String Evaluate;

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
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
}
