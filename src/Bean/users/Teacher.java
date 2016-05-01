package Bean.users;

import Bean.SchoolAssignment.SchoolAssignment;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Feng on 3/29/16.
 */
@Entity
@Table(name = "teacher",schema = "ForumDataBase")
public class Teacher extends User {

    private List<Student>students;
    private List<SchoolAssignment> schoolAssignments;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "teacher")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "teacher")
    public List<SchoolAssignment> getSchoolAssignments() {
        return schoolAssignments;
    }

    public void setSchoolAssignments(List<SchoolAssignment> schoolAssignments) {
        this.schoolAssignments = schoolAssignments;
    }
}
