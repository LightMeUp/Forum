package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Dao.BaseDao;
import com.SE3Forum.fzu.Dao.TeacherDao;
import com.SE3Forum.fzu.Dao.UserDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 6/27/16.
 */
public class TeacherService implements ITeacherService {
    private TeacherDao teacherDao;
    public TeacherService(){
         teacherDao = new TeacherDao();
    }
    @Override
    public Boolean addService(Teacher teacher) {

        return  teacherDao.add(teacher);
    }

    @Override
    public void deleteService(Teacher teacher) {
         teacherDao.delete(teacher);
        new UserCountService().deleteService(teacher.getId());
        new UserDao().delete(teacher.getId());
    }

    @Override
    public void updateServcie(Teacher teacher) {

         teacherDao.update(teacher);
    }

    @Override
    public Teacher findService(Class clazz, Serializable id) {
        return (Teacher) teacherDao.find(Teacher.class,id);
    }

    @Override
    public List<Teacher> listAllService(String tableName) {

        return teacherDao.listAll("teacher");
    }

    @Override
    public int getRowsService(String tableName) {
        return teacherDao.getRows("teacher").intValue();
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
    public List<Teacher> findTeacherByOrigin(String origin) {
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
