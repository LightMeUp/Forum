package Bean.SchoolAssignment;

import Bean.users.StudentEntity;
import Bean.users.TeacherEntity;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 4/14/16.
 */
@Entity
@Table(name = "schoolAssignment",schema = "ForumDataBase")
public class SchoolAssignment {

    /*
    * 作业
    * 作业由教师布置,学生上传
    * 每个作业包括
    * 作业ID(primary key)
    * 作业发布时间(createDate)
    * 作业发布老师(teacher, 一对多, 一个老师可以发布多份作业,)
    * 作业提交截止时间(deadline)
    * 作业内容(文件,文字)
    * 作业评价(Evaluation, 一对一 )*/

    // 作业编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // 发布教师
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
    // 发布日期
    private Date publishDate;
    //截止日期
    private Date deadLine;
    //内容
    private String content;
    //  作业提交数量
    private int assignmentNumbers;

    @OneToMany
    private List<Evaluation> evaluations;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAssignmentNumbers() {
        return assignmentNumbers;
    }

    public void setAssignmentNumbers(int assignmentNumbers) {
        this.assignmentNumbers = assignmentNumbers;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
}
