package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
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

    // 初始化Dao 层对象
    public StudentService()
    {
        studentDao = new StudentDao();
    }

    /*个人信息修改,包括密码修改*/
    public Boolean update(Student student){
        try {

            Student stu = (Student) studentDao.find(Student.class, student.getId());
            stu.setName(student.getName());
            stu.setSex(student.getSex());
            stu.setAddress(student.getAddress());
            stu.setBirthDate(student.getBirthDate());
            stu.setCellPhone(student.getCellPhone());
            stu.setEmail(student.getEmail());
            stu.setQqnumber(student.getQqnumber());
            studentDao.update(stu);
            return true;
        }catch (Exception e){
            System.out.println("E:Service:updateStudentService:"+e);
            return false;
        }
    }
    //修改密码,修改密码的同时,修改securityToken
    public boolean resetPassword(String password, Serializable id){
        try {
            Student student = (Student) studentDao.find(Student.class, id);
            student.setPassword(password);
            // 重新产生一组安全验证码
            String securityToken = Utils.getSecurityToken();
            student.setSecurityToken(securityToken);
            studentDao.update(student);
            return true;
        }catch (Exception e){
            System.out.println("Exception:Service:resetPassword"+e);
            return false;
        }
    }

    // 获取单个 个人信息
    public Student getStudent(Serializable id){
        return (Student) studentDao.find(Student.class,id);
    }
    //删除学生信息.用户无法调用
    public Boolean deleteStudent(Serializable id){

        // 查看对象是否存在
        Student student = (Student) studentDao.find(Student.class,id);

        if ( student == null)
        {
            return false;
        }
        else {
            try{
                studentDao.delete(student);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }

    // 获取全部学生信息
    public List<Student> listAll(){
        return studentDao.listAll("student");
    }

    // 查看全部作业成绩
    public List<Evaluation> listAllEvaluations(Serializable id){
        Student student =(Student) studentDao.find(Student.class,id);
        if (student ==null){
            return null;
        }
        else{
            return student.getEvaluations();
        }
    }

    //
    
}
