package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Feng on 5/4/16.
 */
public class EvaluationDao extends BaseDao {
    /*作业评分表操作
    * 1.*/
    public List<Evaluation> listAll(){
        Session session = HibernateUtil.getSession();
        String sql = "from Evaluation as e";
        Query query =session.createQuery(sql);
        return query.list();
    }

}
