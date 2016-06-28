package com.SE3Forum.fzu.Bean.users;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Feng on 3/29/16.
 */
@Entity
@Table(name = "student",schema = "ForumDataBase")
public class Student  {

    private int id;
    private String name;
    private Teacher teacher;
    private Set<Evaluation> evaluations;


    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "teacher_id")
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "student")
    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }
    public void setEvaluations(Set<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

}
