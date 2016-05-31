package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.users.Teacher;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/11/16.
 */
public interface IFilesService {
    //添加
    Boolean addService(uploadFile file);

    //删除
    Boolean deleteService(Serializable id);

    // 修改教师
    Boolean updateServcie(uploadFile file);

    // 查询单个数据
    uploadFile findService(Serializable id);

    // 查看全部数据
    List<Teacher> listAllService(String tableName);

    // 获取行数
    int  getRowsService(String tableName);

    // search by filename
    uploadFile findFileByName(String name);
    //内部先实例化一个SearchOption的对象



    // search by upload date
    List<uploadFile> findFileByuploadDate(Date uploadDate);
    // qq查找
    List<uploadFile> findFilesByValidateDate(Date validateDate);


    // 上面的查找方法里面只要调用这个方法就可以,传入一个SearchOption的枚举类型
    List<uploadFile>findFileWithOption(String Option, SearchOption searchOption);
    /*
        局部变量建议一定要实例话
        List<Teacher> teaches = new Arraylist<>();
        switch(searchOption){
            case: serarchOption{

                // 调用Dao层方法
                teachers = teacherDao


            }
        }
    * */
}
