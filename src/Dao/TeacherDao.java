package Dao;

import Bean.SchoolAssignment.SchoolAssignment;
import Bean.users.Student;
import Bean.users.Teacher;
import Util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 4/27/16.
 */
public class TeacherDao  extends BaseDao{

    // 查找教师下的全部学生
    public List<Student> getStudentsByTeacherId(Serializable id){

        Teacher teacher = (Teacher) findEntity(Teacher.class,id);
        List<Student> students = teacher.getStudents();
        System.out.println(students);
        if (students == null){
            return null;
        }
        else {
            return students;
        }
    }
    // 查看教师发布的全部作业
     public List<SchoolAssignment> getSchoolAssignments(Serializable id){
         Teacher teacher = (Teacher) findEntity(Teacher.class,id);
         if (teacher ==null)return null;
         else return  teacher.getSchoolAssignments();
     }
    //



}
