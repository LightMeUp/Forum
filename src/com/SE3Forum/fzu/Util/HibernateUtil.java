package com.SE3Forum.fzu.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by Feng on 3/30/16.
 */
public class HibernateUtil {
    private static  SessionFactory sessionFactory ;
    private static Session session;
    static {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory  = configuration.buildSessionFactory(serviceRegistry);

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
    public static SessionFactory  getInstanceFactory()
    {
        return sessionFactory;
    }
    public static Session getSession(){

        session= getInstanceFactory().openSession();
        return session;
    }
    public static  void closeSession(){
        if (session != null){
            if (session.isOpen()){
                session.close();
            }
        }
    }
    public static Transaction getTransaction(){
        return session.getTransaction();
    }
}
