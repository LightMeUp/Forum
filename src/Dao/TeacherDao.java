package Dao;

import Bean.SchoolAssignment.SchoolAssignment;
import Bean.users.StudentEntity;
import Bean.users.TeacherEntity;
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

    public List<StudentEntity> getStudentsByTeacherId(Serializable id){

        Session session = HibernateUtil.getSession();
        TeacherEntity teacherEntity =(TeacherEntity)session.get(TeacherEntity.class,id);
        List<StudentEntity> students = teacherEntity.getStudentEntities();
        System.out.println(students);
        if (students == null){
            return null;
        }
        else {
            return students;
        }
    }
    public List<SchoolAssignment> getSchoolAssignmentsByTeacherId(Serializable id){

        Session session = HibernateUtil.getSession();
        TeacherEntity teacher =(TeacherEntity)session.get(TeacherEntity.class,id);

        List<SchoolAssignment> schoolAssignments = teacher.gets
    }

}
