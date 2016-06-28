package com.SE3Forum.fzu.JTest;

import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Dao.BaseDao;
import com.SE3Forum.fzu.Dao.TeacherDao;
import com.SE3Forum.fzu.Service.SchoolAssignmentService;
import com.SE3Forum.fzu.Service.TeacherService;
import com.SE3Forum.fzu.Service.UserCountService;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by Feng on 4/27/16.
 */
public class TeacherTestUnit  {
    @Test
    public void test() {
        UserCountService service = new UserCountService();
        System.out.println(service.getRowsService());

        BaseDao baseDao =new BaseDao();
        System.out.println(baseDao.getRows("UserCount"));


}
    @Test
    public void testTeacher(){
        Teacher teacher= new Teacher();
        teacher.setId(220100102);
        new TeacherService().addService(teacher);

    }
    @Test
    public void testUpdate(){

    }
}
