package JTest;

import Bean.Post_Comments.PostEntity;
import Bean.users.StudentEntity;
import Dao.BaseDao;
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
    //测试查询全部用户信息功能
    public void testList()
    {
        List<StudentEntity> studentEntities;
        try {
            studentEntities = studentEntityBaseDao.findEntities("select * from student");
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
//    @Test
//    public void testPost()
//    {
//        PostDao PostDao = new PostDao();
//        PostEntity postEntity = new PostEntity();
//        postEntity.setContent("zheshiyigeceshishuju");
//        postEntity.setTheme("test");
//        StudentEntity studentEntity = (StudentEntity) studentEntityBaseDao.find(StudentEntity.class,221300000);
//        studentEntity.getPostEntities().add(postEntity);
//        System.out.printf("%s",studentEntity.getName());
//
//    }

    // 删除测试
    @Test
    public void testDelete(){

    }

    //修改测试
    @Test
    public void testUpdate(){

    }

    @Test
    public void testRandomId()
    {
        for (int i= 0; i<10;i++) {
            System.out.println(Util.Utils.getTouristId());
        }

    }
    @Test
    public void getRows()
    {
        BaseDao<StudentEntity> baseDao = new BaseDao<StudentEntity>();
        java.math.BigInteger number = baseDao.getRows("student");
        System.out.println(number);

    }



}
