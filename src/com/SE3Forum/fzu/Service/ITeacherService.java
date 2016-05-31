package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/11/16.
 */
public interface ITeacherService {

    //添加教师
    Boolean addService(Teacher teacher);

    //删除教师
    Boolean deleteService(Serializable id);

    // 修改教师
    Boolean updateServcie(Teacher teacher);

    // 查询单个教师数据
    Teacher findService(Class clazz, Serializable id);

    // 查看全部教师数据
    List<Teacher> listAllService(String tableName);

    // 获取行数
    int  getRowsService(String tableName);

    // 查看全部个人作业信息
    List<Evaluation> listAllEvaluations(Serializable id);

    // 查看单个作业评价信息
    Evaluation listEvaluation(Serializable id);

    // 重置密码
    boolean resetPassword(String password, Serializable id);

    //获取全部学生信息, 有别与学生表下的查询全部学生信息,获取单个学生信息,通过学号直接搜索学生信息表
    List<Student> listAllStudent(Serializable id);

    // 获取单个学生信息
    List<SchoolAssignment> listAllAssignment(Serializable id);

    // 获取单个作业信息
    SchoolAssignment listSchoolAssignment(Serializable teacherid, Serializable assignmentid);


    // 姓名查找  SearchOption
    Teacher findTeacherByName(String name);
    //内部先实例化一个SearchOption的对象

     // 性别查找
    List<Teacher> findTeacherBySex(String sex);

    // 籍贯查找
    List<Teacher> findTeacherByOrigin(String origin);

    // 邮件查找
    List<Teacher> findTeacherByEmail(String email);
    // 电话查找
    List<Teacher> findTeacherByMobile(String mobile);
    // qq查找
    List<Teacher> findTeacherByQQnumber(String QQnumber);


    // 上面的查找方法里面只要调用这个方法就可以,传入一个SearchOption的枚举类型
    List<Teacher>findTeacherWithOption(String Option, SearchOption searchOption);
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
