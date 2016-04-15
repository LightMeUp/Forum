package BaseDao;

import Bean.users.StudentEntity;
import Util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 3/30/16.
 */
public class BaseDao<T> {

    //  插入数据
        public void addEntity(T object){
            Session session = HibernateUtil.getInstanceFactory().openSession();
            try{
                session.getTransaction().begin();

                session.persist(object);
                session.getTransaction().commit();

            }catch (Exception e){
                e.printStackTrace();
                session.getTransaction().rollback();
                System.out.printf("BaseDao:addEntity:%s",e.getMessage());
            }
            finally {
                session.close();

            }
        }

        // 更新数据
        public void update(T object){
            Session session = HibernateUtil.getInstanceFactory().openSession();
            try{
                session.getTransaction().begin();
                session.update(object);
                session.getTransaction().commit();
            }
            catch (Exception e) {
                session.getTransaction().rollback();
                System.out.printf("BaseDao:update:%s",e.getMessage());
            }
            finally {
                session.close();
            }
        }
        // 删除数据
        public void delete(T object){
            Session session = HibernateUtil.getInstanceFactory().openSession();
            try {
                session.getTransaction().begin();
                session.delete(object);
                session.getTransaction().commit();
            }catch (Exception e){
                session.getTransaction().rollback();

                // log
                System.out.printf("BaseDao:delete:%s",e.getMessage());
            }
        }
        public T find(Class<? extends T> clazz,Serializable id){
            Session session = HibernateUtil.getInstanceFactory().openSession();
            try{
            session.getTransaction().begin();
            return (T)session.get(clazz,id);

            }catch(Exception e){
                session.getTransaction().rollback();
                return null;
            }
            finally {
                session.getTransaction().commit();
                session.close();
            }
        }
        public List<T> list(String sql){
            Session session = HibernateUtil.getInstanceFactory().openSession();
            try{
                session.getTransaction().begin();
                return session.createSQLQuery(sql).addEntity(StudentEntity.class).list();
            }finally {
                session.getTransaction().commit();
                session.close();
            }
        }




}
