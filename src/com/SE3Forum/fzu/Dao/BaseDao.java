package com.SE3Forum.fzu.Dao;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Service.SearchOption;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;
/**
 * Created by Feng on 4/27/16.
 */
public class BaseDao<T> extends HibernateDaoSupport implements  IBaseDao {
    /*
    * BaseDao  实现基本的CURD 操作
    * 1. 获取表的行数 getRows
    * 2. 获取表中全部数据 listAll*/

    @Override
    public boolean add(Object object) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        int effetRow = (int)session.save(object);
        session.getTransaction().commit();
        if (effetRow ==1){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public void delete(Object object) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Object object) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.merge(object);
        session.getTransaction().commit();
    }
    @Override
    public Object find(Class clazz,Serializable id){
        Session session = HibernateUtil.getSession();
        return session.get(clazz,id);
    }


    // query all entities
    @Override
    public List<T> listAll(String table){
        Session session = HibernateUtil.getSession();
        String sql = "SELECT * FROM " +table;
         Query query =session.createSQLQuery(sql);
        return query.list();
    }
    @Override
    public java.math.BigInteger getRows(String tableName){
        Session session = HibernateUtil.getSession();
        Query query = session.createSQLQuery("SELECT count(*) FROM  "+tableName);
        return (java.math.BigInteger) query.list().get(0);
    }


}
