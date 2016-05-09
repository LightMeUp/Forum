package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
/**
 * Created by Feng on 4/30/16.
 */
public class StudentDao extends BaseDao {
    //查看教师
    public Teacher getTeacher(Serializable id) {
        Student student = (Student) find(Student.class, id);
        if (student == null)
            return null;
        else return student.getTeacher();
    }

    // 查看好友列表
    public List<User> getFriends(Serializable id) {
        Student student = (Student) find(Student.class, id);
        if (student == null)
            return null;
        else return student.getFriends();
    }
    // 查看学生的作业评分信息
    public List<Evaluation>  getEvaluations(Serializable id){
        Student student = (Student) find(Student.class, id);
        if (student == null)
            return null;
        else return student.getEvaluations();
    }
    //根据学生姓名查找
    public List<Student> getStudentsByName(String name){
        String Hql ="From Student as s where s.name like ?";
        Session session = HibernateUtil.getSession();
        List<Student> students= session.createQuery(Hql).setString(0,name).list();
        return students;
    }
    //按性别查找
    public List<Student> getStudentsBySex(String sex){
        String Hql ="From Student as s where s.sex = ?";
        Session session = HibernateUtil.getSession();
        List<Student> students= session.createQuery(Hql).setString(0,sex).list();
        return students;
    }
    // 按出生日期查找  查询方式 >=  <= ==
    public List<Student> getStudentsByBirthday(Date date,String searchOption){
        String Hql ="From Student as s where s.birthDate "+searchOption+" ?";
        Session session = HibernateUtil.getSession();
        List<Student> students= session.createQuery(Hql).setDate(0,date).list();
        return students;
    }
    //按联系方式查找    精确查找,模糊查找
    public List<Student> getStudentsByMobile(String mobile,String mobileSearchOption){
        String Hql ="From Student as s where s.cellPhone "+mobileSearchOption+" ?";
        Session session = HibernateUtil.getSession();
        List<Student> students= session.createQuery(Hql).setString(0,mobile).list();
        return students;
    }
    //按联系方式查找    精确查找,模糊查找
    public List<Student> getStudentByQqNumber(String QqNumber,String QqnumberSearchOption){
        String Hql ="From Student as s where s.qqnumber "+QqnumberSearchOption+" ?";
        Session session = HibernateUtil.getSession();
        List<Student> students= session.createQuery(Hql).setString(0,QqNumber).list();
        return students;
    }
}
