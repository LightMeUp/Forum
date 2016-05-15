package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Dao.TeacherDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/9/16.
 */
public class TeacherService   implements  ITeacherService{
    private TeacherDao teacherDao;
    public TeacherService(){
        teacherDao = new TeacherDao();
    }


    @Override
    public Boolean addService(Teacher teacher) {

        try {
            teacherDao.add(teacher);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public Boolean deleteService(Serializable id) {

        Teacher teacher= (Teacher) teacherDao.find(Teacher.class,id);
        if (teacher==null){
            return  false;
        }
        else {
            try {
                teacherDao.delete(teacher);
                return  true;
            }catch (Exception e){
                return  false;
            }
        }
    }

    @Override
    public Boolean updateServcie(Teacher teacher) {
        try {
            Teacher teach= (Teacher) teacherDao.find(Teacher.class,teacher.getId());
            teach.setName(teacher.getName());
            teach.setSex(teacher.getSex());
            teach.setAddress(teacher.getAddress());
            teach.setBirthDate(teacher.getBirthDate());
            teach.setCellPhone(teacher.getCellPhone());
            teach.setEmail(teacher.getEmail());
            teach.setQqnumber(teacher.getQqnumber());
            teacherDao.update(teach);
            return true;
        }catch (Exception e){
            System.out.println("E:Service:updateTeacherService:"+e);
            return false;
        }
    }

    @Override
    public Teacher findService(Class clazz, Serializable id) {
        return (Teacher)teacherDao.find(Teacher.class,id);
    }

    @Override
    public List<Teacher> listAllService(String tableName) {
        return teacherDao.listAll(tableName);
    }

    @Override
    public int getRowsService(String tableName) {
        return 0;
    }

    @Override
    public List<Evaluation> listAllEvaluations(Serializable id) {
        return null;
    }

    @Override
    public Evaluation listEvaluation(Serializable id) {
        return null;
    }

    @Override
    public boolean resetPassword(String password, Serializable id) {
        return false;
    }

    @Override
    public List<Student> listAllStudent(Serializable id) {
        return null;
    }

    @Override
    public List<SchoolAssignment> listAllAssignment(Serializable id) {
        return null;
    }

    @Override
    public SchoolAssignment listSchoolAssignment(Serializable teacherid, Serializable assignmentid) {
        return null;
    }

    @Override
    public Teacher findTeacherByName(String name) {
        return null;
    }

    @Override
    public List<Teacher> findTeacherBySex(String sex) {
        return null;
    }

    @Override
    public List<Teacher> findTeacherByOrigin(String Origin) {
        return null;
    }

    @Override
    public List<Teacher> findTeacherByEmail(String email) {
        return null;
    }

    @Override
    public List<Teacher> findTeacherByMobile(String mobile) {
        return null;
    }

    @Override
    public List<Teacher> findTeacherByQQnumber(String QQnumber) {
        return null;
    }

    @Override
    public List<Teacher> findTeacherWithOption(String Option, SearchOption searchOption) {
        return null;
    }
}
