package Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.service.config.spi.ConfigurationService;

/**
 * Created by Feng on 3/30/16.
 */
public class HibernateUtil {
    private static  SessionFactory sessionFactory ;
    static {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

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
        Session session = getInstanceFactory().getCurrentSession();
        if (session.getTransaction().isActive()){
            return session;
        }
        else {
            return getInstanceFactory().openSession();
        }

    }
}
