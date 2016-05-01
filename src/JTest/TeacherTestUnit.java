package JTest;

import Bean.users.Student;
import Bean.users.Teacher;
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
        Teacher teacher = new Teacher();
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
        Teacher teacher =(Teacher) teacherDao.findEntity(Teacher.class,22010001);
        //BaseDao<StudentEntity> studentDao = new BaseDao<>();
//        StudentEntity studentEntity =studentDao.findEntity(StudentEntity.class,22130001);
//        List<StudentEntity> students = new ArrayList<>();
//        students.add(studentEntity);
//        teacher.setStudentEntities(students);
        teacher.setPassword("123456");
        teacherDao.updateEntity(teacher);

    }
    @Test
    public void TestFind(){
        TeacherDao teacherDao = new TeacherDao();
       List<Student> students = teacherDao.getStudentsByTeacherId(22010001);
        System.out.println(students);
    }
    @Test
    public void TestFindStudents(){
        TeacherDao teacherDao = new TeacherDao();
        List<Student> list = teacherDao.getStudentsByTeacherId("单红");
        System.out.println("students:"+list);

    }
    @Test
    public void TestFindTeacher(){
        TeacherDao teacherDao = new TeacherDao();
        Teacher teacherEntity = (Teacher) teacherDao.findEntity(Teacher.class,22010001);
        System.out.println("count:"+teacherEntity.getId() +"passowrd:"+teacherEntity.getPassword());
    }

}
