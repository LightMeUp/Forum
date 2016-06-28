package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Feng on 4/27/16.
 */
public class TeacherDao  extends BaseDao{

    // 查找教师下的全部学生
    public Set<Student> getStudentsByTeacherId(Serializable id){

        Teacher teacher = (Teacher) find(Teacher.class,id);
        Set<Student> students = teacher.getStudents();
        System.out.println(students);
        if (students == null){
            return null;
        }
        else {return students;}
    }
    // 查看教师发布的全部作业
     public Set<SchoolAssignment> getSchoolAssignments(Serializable id){

         Teacher teacher = (Teacher) find(Teacher.class,id);
         if (teacher ==null)return null;
         else return  teacher.getSchoolAssignments();
     }
}
