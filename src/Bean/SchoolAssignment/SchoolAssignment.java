package Bean.SchoolAssignment;

import Bean.users.StudentEntity;
import Bean.users.TeacherEntity;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Feng on 4/14/16.
 */
public class SchoolAssignment {

    /*
    * 作业
    * 作业由教师布置,学生上传
    * 每个作业包括
    * 作业ID(primary key)
    * 作业发布时间(createDate)
    * 作业发布老师(teacher, 一对多, 一个老师可以发布多份作业,)
    * 学生(一个学生有多个作业)
    * 作业提交截止时间(deadline)
    * 作业内容(文件,文字)
    * 作业评价(Evaluation, 一对一 )*/




}
