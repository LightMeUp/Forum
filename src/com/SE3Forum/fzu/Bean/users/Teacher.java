package com.SE3Forum.fzu.Bean.users;

import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Feng on 3/29/16.
 */
@Entity
@Table(name = "teacher",schema = "ForumDataBase")
public class Teacher  {

    private int id;
    private Set<Student> students;
    private Set<SchoolAssignment> schoolAssignments;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "teacher")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
    public Set<SchoolAssignment> getSchoolAssignments() {
        return schoolAssignments;
    }

    public void setSchoolAssignments(Set<SchoolAssignment> schoolAssignments) {
        this.schoolAssignments = schoolAssignments;
    }
}
