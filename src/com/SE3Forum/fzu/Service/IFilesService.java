package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Data.Files;
import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/11/16.
 */
public interface IFilesService {
    //添加
    Boolean addService(Files file);

    //删除
    Boolean deleteService(Serializable id);

    // 修改教师
    Boolean updateServcie(Files file);

    // 查询单个数据
    Files findService(Class  clazz,Serializable id);

    // 查看全部数据
    List<Teacher> listAllService(String tableName);

    // 获取行数
    int  getRowsService(String tableName);

    // 查看全部
    List<Files> listAllFiles(Serializable id);


    // search by filename
    Files findFileByName(String name);
    //内部先实例化一个SearchOption的对象



    // search by upload date
    List<Files> findFileByuploadDate(Date uploadDate);
    // qq查找
    List<Files> findFilesByValidateDate(Date validateDate);


    // 上面的查找方法里面只要调用这个方法就可以,传入一个SearchOption的枚举类型
    List<Files>findFileWithOption(String Option,SearchOption searchOption );
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
