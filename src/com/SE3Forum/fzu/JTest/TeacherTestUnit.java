package com.SE3Forum.fzu.JTest;

import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Dao.BaseDao;
import com.SE3Forum.fzu.Dao.TeacherDao;
import com.SE3Forum.fzu.Service.UserCountService;
import org.junit.Test;

import java.util.List;

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
}
