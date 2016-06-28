package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Dao.EvaluationDao;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/9/16.
 */
/*
* 作业评分
* 作业评分在用户提交作业时生成
* 教师对表进行修改*/


public class EvaluationService implements IEvaluationService {
    private EvaluationDao evaluationDao;
    public EvaluationService(){evaluationDao=new EvaluationDao();}

    /* 添加新的作业评分表,学生提交作业时生成*/
    @Override
    public Boolean addService(Evaluation evaluation) {
        try {
            /*学生如果多次提交作业*/

            evaluationDao.add(evaluation);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteService(Serializable id) {
        Evaluation evaluation= (Evaluation) evaluationDao.find(Evaluation.class, id);
        if (evaluation==null){
            return false;
        }else {
            try{
                evaluationDao.delete(evaluation);
                return true;
            }catch (Exception e){
                return false;
            }
        }
    }

    @Override
    public Boolean updateServcie(Evaluation evaluation) {
        try {
            Evaluation e= (Evaluation) evaluationDao.find(Evaluation.class,evaluation.getId());
            e.setCreatedDate(evaluation.getCreatedDate());
            e.setEvaluate(evaluation.getEvaluate());
            e.setSchoolAssignment(evaluation.getSchoolAssignment());
            e.setScore(evaluation.getScore());
            e.setStudent(evaluation.getStudent());
            evaluationDao.update(e);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Evaluation findService( Serializable id) {
        return (Evaluation) evaluationDao.find(Evaluation.class,id);
    }

    @Override
    public List<Evaluation> listAllService() {
        return evaluationDao.listAll();
    }

    @Override
    public int getRowsService() {
        evaluationDao.getRows("evaluation");
        return 0;
    }

    public Evaluation getEvaluationByStudentAndAssignment(int studentId, int AssignmentId){
        Session session = HibernateUtil.getSession();
        String Hql = "from Evaluation  as e where e.schoolAssignment.id=:saId AND e.student.id=:sId";
        Query query =session.createQuery(Hql).setInteger("saId",AssignmentId).setInteger("sId",studentId);
        return query.list()!=null &&query.list().size()>0?(Evaluation) query.list().get(0):null;
    }

    @Override
    public List<Evaluation> findEvaluationByCreatedDate(Date createDate) {
        return null;
    }

    @Override
    public List<Evaluation> findFileWithOption(String Option, SearchOption searchOption) {
        return null;
    }
}
