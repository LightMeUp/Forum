package com.SE3Forum.fzu.Bean.users;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Feng on 3/29/16.
 */
@Entity
@Table(name = "student",schema = "ForumDataBase")
public class Student extends User {

    private Teacher teacher;
    private List<Evaluation> evaluations;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "teacher_id")
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "student")
    public List<Evaluation> getEvaluations() {
        return evaluations;
    }
    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

}
