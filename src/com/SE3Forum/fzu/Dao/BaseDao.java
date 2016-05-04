package com.SE3Forum.fzu.Dao;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import java.io.Serializable;
import java.util.List;
/**
 * Created by Feng on 4/27/16.
 */
public class BaseDao<T>  implements  IBaseDao{

    @Override
    public boolean addEntity(Object object) {
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
    public void deleteEntity(Object object) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateEntity(Object object) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Object findEntity(Class clazz, Serializable id) {
        Session session = HibernateUtil.getSession();
        T object =(T)session.get(clazz, id);
        session.close();
        return object;
    }

    // query all entities
    @Override
    public List<T> findEntities(String sql){
        Session session = HibernateUtil.getSession();
        Query query = session.createSQLQuery(sql);
        session.close();
        return query.list();
    }
    @Override
    public java.math.BigInteger getRows(String tableName){
        Session session = HibernateUtil.getSession();
        Query query = session.createSQLQuery("SELECT count(*) FROM  "+tableName);
        return (java.math.BigInteger) query.list().get(0);
    }

}
