package JTest;

import BaseDao.BaseDao;
import Bean.StudentEntity;
import Bean.TeacherEntity;
import Bean.UserEntity;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Feng on 3/30/16.
 */
public class TestUnit {
    public TestUnit(){

    }

    @Test
    public void TestAdd()
    {
        BaseDao<StudentEntity> studentEntityBaseDao = new BaseDao<StudentEntity>();
        try {
            StudentEntity userEntity = new StudentEntity();
            userEntity.setId(221300000);
            userEntity.setPassword("221300000");
            userEntity.setAddress("福建省福州市闽侯县上街镇福州大学博学院B区");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = simpleDateFormat.parse("2016-3-31");

            userEntity.setBirthDate( new java.sql.Date(date.getTime()));
            userEntity.setCellPhone("12345678900");

            Date loginDate = new Date();
            userEntity.setLastLoginDate( new java.sql.Date(loginDate.getTime()));
            userEntity.setSex("男");
            studentEntityBaseDao.addEntity(userEntity);


            System.out.printf("completed");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
