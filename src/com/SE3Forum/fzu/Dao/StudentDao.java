package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Feng on 4/30/16.
 */
public class StudentDao extends BaseDao {
    //查看教师
    public Teacher getTeacher(Serializable id) {
        Student student = (Student) find(Student.class, id);
        if (student == null)
            return null;
        else {
            Teacher teacher = student.getTeacher();
            HibernateUtil.getSession().close();
            return teacher;
        }
    }

    // 查看学生的作业评分信息
    public Set<Evaluation>  getEvaluations(Serializable id){
        Student student = (Student) find(Student.class, id);
        if (student == null)
            return null;
        else return student.getEvaluations();
    }

}
