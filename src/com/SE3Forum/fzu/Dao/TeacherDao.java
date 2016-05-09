package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 4/27/16.
 */
public class TeacherDao  extends BaseDao{

    // 查找教师下的全部学生
    public List<Student> getStudentsByTeacherId(Serializable id){

        Teacher teacher = (Teacher) find(Teacher.class,id);
        List<Student> students = teacher.getStudents();
        System.out.println(students);
        if (students == null){
            return null;
        }
        else {return students;}
    }
    // 查看教师发布的全部作业
     public List<SchoolAssignment> getSchoolAssignments(Serializable id){

         Teacher teacher = (Teacher) find(Teacher.class,id);
         if (teacher ==null)return null;
         else return  teacher.getSchoolAssignments();
     }
    //根据学生姓名查找
    public List<Teacher> getTeacherByName(String name){

        String Hql ="From Student as s where s.name like ?";
        Session session = HibernateUtil.getSession();
        List<Teacher> teachers= session.createQuery(Hql).setString(0,name).list();
        return teachers;
    }
    //按性别查找
    public List<Teacher> getStudentsBySex(String sex){

        String Hql ="From Student as s where s.sex = ?";
        Session session = HibernateUtil.getSession();
        List<Teacher> teachers= session.createQuery(Hql).setString(0,sex).list();
        return teachers;
    }
    // 按出生日期查找  查询方式 >=  <= ==
    public List<Teacher> getStudentsByBirthday(Date date, String searchOption){

        String Hql ="From Student as s where s.birthDate "+searchOption+" ?";
        Session session = HibernateUtil.getSession();
        List<Teacher> teachers= session.createQuery(Hql).setDate(0,date).list();
        return teachers;
    }
    //按联系方式查找    精确查找,模糊查找
    public List<Teacher> getStudentsByMobile(String mobile,String mobileSearchOption){

        String Hql ="From Student as s where s.cellPhone "+mobileSearchOption+" ?";
        Session session = HibernateUtil.getSession();
        List<Teacher> teachers= session.createQuery(Hql).setString(0,mobile).list();
        return teachers;
    }
    //按联系方式查找    精确查找,模糊查找
    public List<Teacher> getStudentByQqNumber(String QqNumber,String QqnumberSearchOption){

        String Hql ="From Student as s where s.qqnumber "+QqnumberSearchOption+" ?";
        Session session = HibernateUtil.getSession();
        List<Teacher> teachers= session.createQuery(Hql).setString(0,QqNumber).list();
        return teachers;
    }
}
