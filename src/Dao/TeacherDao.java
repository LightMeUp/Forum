package Dao;

import Bean.SchoolAssignment.SchoolAssignment;
import Bean.users.Student;
import Bean.users.Teacher;
import Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Feng on 4/27/16.
 */
public class TeacherDao  extends BaseDao{

    public List<Student> getStudentsByTeacherId(Serializable id){

        Session session = HibernateUtil.getSession();
        Teacher teacherEntity =(Teacher)session.get(Teacher.class,id);
        List<Student> students = teacherEntity.getStudents();
        System.out.println(students);
        if (students == null){
            return null;
        }
        else {
            return students;
        }
    }

}
