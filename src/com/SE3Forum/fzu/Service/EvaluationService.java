package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Dao.EvaluationDao;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/9/16.
 */
public class EvaluationService implements IEvaluationService {
    private EvaluationDao evaluationDao;
    public EvaluationService(){evaluationDao=new EvaluationDao();}
    @Override
    public Boolean addService(Evaluation evaluation) {
        try {
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
    public Evaluation findService(Class clazz, Serializable id) {
        return (Evaluation) evaluationDao.find(Evaluation.class,id);
    }

    @Override
    public List<Evaluation> listAllService(String tableName) {
        return evaluationDao.listAll(tableName);
    }

    @Override
    public int getRowsService(String tableName) {
        return 0;
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
