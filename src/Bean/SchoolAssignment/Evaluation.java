package Bean.SchoolAssignment;

import Bean.users.StudentEntity;
import Bean.users.TeacherEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Feng on 4/14/16.
 */
@Entity
@Table(name = "evaluation")
public class Evaluation {

    private int id;
    private SchoolAssignment schoolAssignment;
    private StudentEntity studentEntity;
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
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
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
