package com.SE3Forum.fzu.JTest;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Service.TeacherService;
import org.junit.Test;

/**
 * Created by zhu on 2016/5/14.
 */
public class TeacherServiceTest {
    @Test
    public void TestAddService(){
        //addservice
        //
        TeacherService teacherService=new TeacherService();
        Teacher teacher = new Teacher();
        teacher.setId(22010001);
        teacher.setName("单红");
        teacher.setSex("男");
        teacher.setAddress("福建省福州市闽侯县上街镇福州大学软件学院");
        teacher.setCellPhone("12345678910");
        teacherService.addService(teacher);
        System.out.print(teacherService.addService(teacher));
    }
}

