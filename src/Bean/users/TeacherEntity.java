package Bean.users;

import Bean.SchoolAssignment.SchoolAssignment;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Feng on 3/29/16.
 */
@Entity
@Table(name = "teacher")
public class TeacherEntity extends UserEntity {

    // 学生
    private List<StudentEntity>studentEntities;
    private List<SchoolAssignment> schoolAssignments;


    @OneToMany(fetch = FetchType.LAZY)
    public List<StudentEntity> getStudentEntities() {
        return studentEntities;
    }



    public void setStudentEntities(List<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }

}
