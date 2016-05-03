package Dao;

import Bean.Post_Comments.Post;
import Bean.users.Teacher;
import Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import java.io.Serializable;
import java.util.List;
/**
 * Created by Feng on 4/27/16.
 */
public class BaseDao<T> {

    // 添加数据
    public boolean addEntity(T object){
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        int effetRow = (int)session.save(object);
        session.getTransaction().commit();
        if (effetRow ==1){
            session.close();
            return true;
        }
        else {
            session.close();
            return false;
        }
    }

    // delete Row

    public void deleteEntity(T object){
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    // update row
    public void updateEntity(T object){
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }
    public T findEntity(Class<T>clazz, Serializable id){
        Session session = HibernateUtil.getSession();
        T object =(T)session.get(clazz, id);
        session.close();
        return object;
    }
    // query all entities
    public List<T> findEntities(String sql){
        Session session = HibernateUtil.getSession();
        Query query = session.createSQLQuery(sql);
        session.close();
        return query.list();
    }
    public java.math.BigInteger getRows(String tableName){
        Session session = HibernateUtil.getSession();
        Query query = session.createSQLQuery("SELECT count(*) FROM  "+tableName);
        session.close();
        return (java.math.BigInteger) query.list().get(0);
    }

}
