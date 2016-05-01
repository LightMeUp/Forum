package Bean.users;

import Bean.SchoolAssignment.Evaluation;
import Bean.SchoolAssignment.SchoolAssignment;
import org.hibernate.annotations.Fetch;

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
    /*学生权限表
    * 下载文件的权限
    * 上传作业的权限
    * 发帖 评论
    * 管理权限   包括管理学生,老师信息,删帖,禁言.
    * */


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
