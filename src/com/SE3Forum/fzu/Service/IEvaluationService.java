package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Data.Files;
import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.users.Teacher;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/11/16.
 */
public interface IEvaluationService {
    //添加
    Boolean addService(Evaluation evaluation);

    //删除
    Boolean deleteService(Serializable id);

    // 修改教师
    Boolean updateServcie(Evaluation evaluation);

    // 查询单个数据
    Evaluation findService(Class  clazz, Serializable id);

    // 查看全部数据
    List<Evaluation> listAllService(String tableName);

    // 获取行数
    int  getRowsService(String tableName);



    // search by student submit schoolAssigmen Date
    List<Evaluation> findEvaluationByCreatedDate(Date createDate);


    // 上面的查找方法里面只要调用这个方法就可以,传入一个SearchOption的枚举类型
    List<Evaluation>findFileWithOption(String Option,SearchOption searchOption );
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
