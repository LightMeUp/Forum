package BaseDao;

import Bean.Post_Comments.PostEntity;
import Bean.users.UserEntity;
import Bean.users.StudentEntity;
import Util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 4/8/16.
 */
public class PostDao  {
        //  插入数据
        // 发帖插入时需要传入两个对象一个是表单对象,一个是发帖人对象
        public void addEntity(PostEntity post, UserEntity user){
            Session session = HibernateUtil.getInstanceFactory().openSession();
            BaseDao<UserEntity> userDao = new BaseDao<UserEntity>();
            try{

                session.getTransaction().begin();
                session.persist(post);
                user.getPostEntities().add(post);


                // 保存两个表单之间的关系
                session.save(user);
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
        public void update(PostEntity object){
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
        public void delete(PostEntity object){
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
        public PostEntity find(Class<? extends PostEntity> clazz, Serializable id){
            Session session = HibernateUtil.getInstanceFactory().openSession();
            try{
                session.getTransaction().begin();
                return (PostEntity) session.get(clazz,id);

            }catch(Exception e){
                session.getTransaction().rollback();
                return null;
            }
            finally {
                session.getTransaction().commit();
                session.close();
            }
        }
        public List<PostEntity> list(String sql){
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
