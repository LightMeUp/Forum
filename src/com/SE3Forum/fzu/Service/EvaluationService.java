package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Feng on 5/9/16.
 */
public class EvaluationService implements IEvaluationService {

    @Override
    public Boolean addService(Evaluation evaluation) {
        return null;
    }

    @Override
    public Boolean deleteService(Serializable id) {
        return null;
    }

    @Override
    public Boolean updateServcie(Evaluation evaluation) {
        return null;
    }

    @Override
    public Evaluation findService(Class clazz, Serializable id) {
        return null;
    }

    @Override
    public List<Evaluation> listAllService(String tableName) {
        return null;
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
