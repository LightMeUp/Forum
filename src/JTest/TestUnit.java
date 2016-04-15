package JTest;

import BaseDao.BaseDao;
import BaseDao.PostDao;
import Bean.Post_Comments.PostEntity;
import Bean.users.StudentEntity;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Feng on 3/30/16.
 */
public class TestUnit {
    BaseDao<StudentEntity> studentEntityBaseDao = new BaseDao<StudentEntity>();
    public TestUnit(){

    }

    @Test
    public void TestAdd()
    {

        // 测试创建新用户
        try {
            StudentEntity userEntity = new StudentEntity();
            userEntity.setId(22130001);
            userEntity.setPassword("221300001");
            userEntity.setAddress("福建省福州市闽侯县上街镇福州大学博学院B区");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date date = simpleDateFormat.parse("2016-3-31");

            userEntity.setBirthDate( new java.sql.Date(date.getTime()));
            userEntity.setCellPhone("12345678901");

            Date loginDate = new Date();
            userEntity.setLastLoginDate( new java.sql.Date(loginDate.getTime()));
            userEntity.setSex("男");
            studentEntityBaseDao.addEntity(userEntity);


            System.out.printf("completed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    //测试查询全部用户信息功能
    public void testList()
    {
        List<StudentEntity> studentEntities;
        try {
            studentEntities = studentEntityBaseDao.list("select * from student");
            if (studentEntities == null || studentEntities.size() < 1){
                System.out.println("no user");
            }
            else {
                for (int i = 0; i<studentEntities.size();i++){
                    System.out.println(studentEntities.get(i).getName() + studentEntities.get(i).getId()+studentEntities.get(i).getSex());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //测试发帖数据库的插入
    @Test
    public void testPost()
    {
        PostDao PostDao = new PostDao();
        PostEntity postEntity = new PostEntity();
        postEntity.setContent("zheshiyigeceshishuju");
        postEntity.setTheme("test");
        StudentEntity studentEntity = studentEntityBaseDao.find(StudentEntity.class,221300000);
        studentEntity.getPostEntities().add(postEntity);
        System.out.printf("%s",studentEntity.getName());


        PostDao.addEntity(postEntity,studentEntity);

    }


}
