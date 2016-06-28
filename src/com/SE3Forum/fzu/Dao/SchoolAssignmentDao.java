package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/4/16.
 */


/*
* 作业类Data Access to Data*/
public class SchoolAssignmentDao extends BaseDao {
    /*作业只需要执行基础的CURD 不需要执行额外的操作

    * */

    public List<SchoolAssignment> listAll(){
        Session session = HibernateUtil.getSession();
        String sql = "from SchoolAssignment as s";
        Query query =session.createQuery(sql);
        return query.list();
    }
    public List<SchoolAssignment> findSchoolAssignmentByTeacherId(Serializable id){
        Session session = HibernateUtil.getSession();
        String Hql ="from SchoolAssignment as s where  s.teacher.id = "+id;
        Query query =session.createQuery(Hql);
        return query.list();
    }
}
