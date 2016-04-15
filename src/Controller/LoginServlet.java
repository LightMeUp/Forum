package Controller;

import Bean.users.UserEntity;
import Util.HibernateUtil;
import org.hibernate.Session;

import java.io.IOException;

/**
 * Created by Feng on 3/31/16.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            this.doPost(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Session session = HibernateUtil.getInstanceFactory().openSession();
        try{
            session.getTransaction().begin();
            session.get(UserEntity.class,request.getParameter("id"));
            session.getTransaction().commit();
            

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }




    }
}
