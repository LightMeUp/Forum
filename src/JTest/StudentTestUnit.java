package JTest;

import Bean.users.StudentEntity;
import Bean.users.TeacherEntity;
import Dao.BaseDao;
import Dao.TeacherDao;
import org.hibernate.Session;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Feng on 4/27/16.
 */
public class StudentTestUnit {
    @Test
    public void TestAdd()
    {
        BaseDao<StudentEntity> studentDao = new BaseDao<>();
        // 测试创建新用户
        try {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(22130001);
            studentEntity.setPassword("221300001");
            studentEntity.setAddress("福建省福州市闽侯县上街镇福州大学博学院B区");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = simpleDateFormat.parse("2016-3-31");

            studentEntity.setBirthDate( new java.sql.Date(date.getTime()));
            studentEntity.setCellPhone("12345678901");

            Date loginDate = new Date();
            studentEntity.setLastLoginDate( new java.sql.Date(loginDate.getTime()));
            studentEntity.setSex("男");
            studentDao.addEntity(studentEntity);
            System.out.printf("completed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestDelete(){
        BaseDao<StudentEntity> studentDao = new BaseDao<>();
        StudentEntity studentEntity = studentDao.findEntity(StudentEntity.class,22130001);
        if (studentEntity  == null){
            System.out.print("Student is not exits");
        }
        else {
            studentDao.deleteEntity(studentEntity);
            System.out.println("student delete from student table");
        }
    }
    @Test
    public void TestUpdate(){
       BaseDao<StudentEntity> studentDao  = new BaseDao<>();
        StudentEntity studentEntity = studentDao.findEntity(StudentEntity.class, 22130001);
        if (studentEntity == null){
            System.out.println("student not exits,update failed");
        }
        else {
            /* 使用对象的set方法重新修改信息*/
            TeacherEntity teacher = (TeacherEntity) new TeacherDao().findEntity(TeacherEntity.class,22010001);
            studentEntity.setTeacherEntity(teacher);
            studentDao.updateEntity(studentEntity);
            System.out.println("new student information updated");
        }
    }
    @Test
    public void TestFind()
    {
        BaseDao<StudentEntity> studentDao = new BaseDao<>();
        StudentEntity student = studentDao.findEntity(StudentEntity.class, 22130001);
        if (student == null){
            System.out.println("student not exits");
        }
        else {
            System.out.println("student:"+student.getSex());
        }

    }
}
