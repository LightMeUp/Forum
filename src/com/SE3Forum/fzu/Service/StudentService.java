package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Dao.StudentDao;
import com.SE3Forum.fzu.Util.Utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/8/16.
 */
public class StudentService {
    private StudentDao studentDao;
    /*查找学生信息
    1. 单一条件查找
    * 查找包括 学号查找 姓名查找 性别查找 籍贯查找 出生日期查找,邮箱查找,电话查找,QQ号码查找
    *           */

    /*修改学生信息*/
    public StudentService()
    {
        studentDao = new StudentDao();
    }

    /*个人信息xi修改,包括密码修改*/
    public Boolean updateStudent(Student student){
        try {

            Student stu = (Student) studentDao.findEntity(Student.class, student.getId());
            stu.setName(student.getName());
            stu.setSex(student.getSex());
            stu.setAddress(student.getAddress());
            stu.setBirthDate(student.getBirthDate());
            stu.setCellPhone(student.getCellPhone());
            stu.setEmail(student.getEmail());
            stu.setQqnumber(student.getQqnumber());
            studentDao.updateEntity(stu);
            return true;
        }catch (Exception e){
            System.out.println("E:Service:updateStudentService:"+e);
            return false;
        }
    }
    //修改密码,修改密码的同时,修改securityToken
    public boolean resetPassword(String password, Serializable id){
        try {
            Student student = (Student) studentDao.findEntity(Student.class, id);
            student.setPassword(password);
            // 重新产生一组安全验证码
            String securityToken = Utils.getSecurityToken();
            student.setSecurityToken(securityToken);
            studentDao.updateEntity(student);
            return true;
        }catch (Exception e){
            System.out.println("Exception:Service:resetPassword"+e);
            return false;
        }
    }

    // 获取个人信息
    public Student getStudent(Serializable id){
        return (Student) studentDao.findEntity(Student.class,id);
    }
    //删除学生信息.用户无法调用

    
}
