package com.SE3Forum.fzu.JTest;

import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Dao.StudentDao;
import com.SE3Forum.fzu.Dao.TeacherDao;
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
        StudentDao studentDao = new StudentDao();
        // 测试创建新用户
        try {
            Student student = new Student();
            student.setId(22130001);
            student.setPassword("221300001");
            student.setAddress("福建省福州市闽侯县上街镇福州大学博学院B区");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = simpleDateFormat.parse("2016-3-31");

            student.setBirthDate( new java.sql.Date(date.getTime()));
            student.setCellPhone("12345678901");

            Date loginDate = new Date();
            student.setLastLoginDate( new java.sql.Date(loginDate.getTime()));
            student.setSex("男");
            studentDao.addEntity(student);
            System.out.printf("completed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestDelete(){
        StudentDao studentDao = new StudentDao();
        Student studentEntity = (Student) studentDao.findEntity(Student.class,22130001);
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
        StudentDao studentDao = new StudentDao();
        Student studentEntity = (Student) studentDao.findEntity(Student.class, 22130001);
        if (studentEntity == null){
            System.out.println("student not exits,update failed");
        }
        else {
            /* 使用对象的set方法重新修改信息*/
            Teacher teacher = (Teacher) new TeacherDao().findEntity(Teacher.class,22010001);
            studentEntity.setTeacher(teacher);
            studentDao.updateEntity(studentEntity);
            System.out.println("new student information updated");
        }
    }
    @Test
    public void TestFind()
    {
        StudentDao studentDao = new StudentDao();
        Student student = (Student) studentDao.findEntity(Student.class, 221300101);
        if (student == null){
            System.out.println("student not exits");
        }
        else {
            System.out.println("student:"+student.getSex());
        }

    }
    @Test
    public void TestGetRows()
    {
        StudentDao studentDao = new StudentDao();
        java.math.BigInteger n = studentDao.getRows("student");
        System.out.println(n);
    }
}
