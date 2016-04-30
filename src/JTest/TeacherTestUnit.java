package JTest;

import Bean.users.StudentEntity;
import Bean.users.TeacherEntity;
import Dao.BaseDao;
import Dao.TeacherDao;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Feng on 4/27/16.
 */
public class TeacherTestUnit  {
    @Test
    public void TestAddTeacher(){
        TeacherDao teacherDao = new TeacherDao();
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(22010001);
        teacher.setName("单红");
        teacher.setSex("男");
        teacher.setAddress("福建省福州市闽侯县上街镇福州大学软件学院");
        teacher.setCreatedDate(new Date(new java.util.Date().getTime()));
        teacher.setCellPhone("12345678910");
        teacherDao.addEntity(teacher);
        System.out.println("new Teacher added");
    }


    @Test
    public void TestUpdate(){
        TeacherDao teacherDao = new TeacherDao();
        TeacherEntity teacher =(TeacherEntity) teacherDao.findEntity(TeacherEntity.class,22010001);
        BaseDao<StudentEntity> studentDao = new BaseDao<>();
        StudentEntity studentEntity =studentDao.findEntity(StudentEntity.class,22130001);
        List<StudentEntity> students = new ArrayList<>();
        students.add(studentEntity);
        teacher.setStudentEntities(students);
        teacherDao.updateEntity(teacher);

    }
    @Test
    public void TestFind(){
        TeacherDao teacherDao = new TeacherDao();
       List<StudentEntity> students = teacherDao.getStudentsByTeacherName("danhong");
        System.out.println(students);
    }
    @Test
    public void TestFindStudents(){
        TeacherDao teacherDao = new TeacherDao();
        List<StudentEntity> list = teacherDao.getStudentsByTeacherName("单红");
        System.out.println("students:"+list);

    }
}
