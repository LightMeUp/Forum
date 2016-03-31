package Bean;

import org.hibernate.SQLQuery;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 3/29/16.
 */
@Entity
@Table(name = "teacher")
public class TeacherEntity extends UserEntity {


    private List<StudentEntity>studentEntities;



    @OneToMany
    @JoinColumn(name = "student_id")
    public List<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(List<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }


}
