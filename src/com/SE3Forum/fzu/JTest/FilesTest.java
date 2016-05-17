package com.SE3Forum.fzu.JTest;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Dao.BaseDao;
import com.SE3Forum.fzu.Service.StudentService;
import com.SE3Forum.fzu.Util.Utils;
import org.junit.Test;

/**
 * Created by Feng on 5/11/16.
 */
public class FilesTest  {
    @Test
    public void testAddFile()
    {
        BaseDao filesDao = new BaseDao();
        StudentService studentService = new StudentService();
        Student student = studentService.findService(Student.class,221300201);
        uploadFile file = new uploadFile();
        file.setName("testFile");
        file.setUuid(Utils.getRandomUUID());
        file.setDescription("testFile");
        file.setUploadDate(Utils.getCurrentDate().toString());
        System.out.println(Utils.getCurrentDate().toString());
        //file.setUser(student);
        filesDao.add(file);
    }
}
