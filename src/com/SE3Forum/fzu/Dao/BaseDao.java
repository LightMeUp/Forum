package com.SE3Forum.fzu.Dao;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
/**
 * Created by Feng on 4/27/16.
 */
public class BaseDao<T> implements  IBaseDao {
    /*
    * BaseDao  实现基本的CURD 操作
    * 1. 获取表的行数 getRows
    * 2. 获取表中全部数据 listAll*/

    @Override
    public boolean add(Object object) {
        Session session = HibernateUtil.getSession();
        try {
            session.getTransaction().begin();
            int effetRow = (int) session.save(object);
            session.getTransaction().commit();
            if (effetRow == 1) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
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
        try {
            session.getTransaction().begin();
            session.merge(object);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }

    }
    @Override
    public Object find(Class clazz,Serializable id){
        Session session = HibernateUtil.getSession();
         Object objec =session.get(clazz,id);
        session.close();
        return objec;
    }


    // query all entities
    @Override
    public List<T> listAll(String table){
        Session session = HibernateUtil.getSession();
            String sql = "SELECT * FROM " + table;
            List<T> list = session.createSQLQuery(sql).list();
        session.close();
        return  list;
    }
    @Override
    public java.math.BigInteger getRows(String tableName){
        Session session = HibernateUtil.getSession();
        Query query = session.createSQLQuery("SELECT count(*) FROM  "+tableName);
        java.math.BigInteger number = (java.math.BigInteger) query.list().get(0);
        session.close();
        return number;
    }


}
