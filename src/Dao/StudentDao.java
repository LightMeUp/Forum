package Dao;

import Bean.SchoolAssignment.Evaluation;
import Bean.users.Student;
import Bean.users.Teacher;
import Bean.users.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 4/30/16.
 */
public class StudentDao extends BaseDao {
    //查看教师
    public Teacher getTeacher(Serializable id) {
        Student student = (Student) findEntity(Student.class, id);
        if (student == null)
            return null;
        else return student.getTeacher();
    }

    // 查看好友列表
    public List<User> getFriends(Serializable id) {
        Student student = (Student) findEntity(Student.class, id);
        if (student == null)
            return null;
        else return student.getFriends();
    }
    // 查看学生的作业评分信息
    public List<Evaluation>  getEvaluations(Serializable id){
        Student student = (Student) findEntity(Student.class, id);
        if (student == null)
            return null;
        else return student.getEvaluations();
    }

}
