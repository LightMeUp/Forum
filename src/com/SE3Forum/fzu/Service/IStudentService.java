package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.users.Student;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/11/16.
 */
public interface IStudentService {
    // 添加服务
    Boolean addService(Student student);

    //删除
    Boolean deleteService(Serializable id);

    // 修改
    Boolean updateServcie(Student student);

    // 查询单个数据
    Student findService(Class  clazz,Serializable id);

    // 查看全部数据
    List<Student> listAllService(String tableName);

    int  getRowsService(String tableName);

    // 查看全部个人作业信息
    List<Evaluation> listAllEvaluations(Serializable id);

    // 查看单个作业评价信息
    Evaluation listEvaluation(Serializable id);

     boolean resetPassword(String password, Serializable id);

}
