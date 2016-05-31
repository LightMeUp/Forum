package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.SearchOption;
import com.SE3Forum.fzu.Util.HibernateUtil;
import com.SE3Forum.fzu.Util.Utils;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Feng on 5/23/16.
 */
public class UserCountDao   extends BaseDao{

    /*
    *  此处封装对用户账户信息的处理,这样在进行登录的时候就不需要判断登录对象类型*/

    public List<UserCount>  findByOption(String queryString, SearchOption searchOption){
        String hql  ="From UserCount as user where   ";
        Session session = HibernateUtil.getSession();
        switch (searchOption){
            /* 姓名查找*/
            case nameOption:
                hql += "user.name like %?%";
                 session = HibernateUtil.getSession();
               return  session.createQuery(hql).setParameter(1,queryString).list();
            case sexOption:
                hql += "user.sex like %?%";
                return  session.createQuery(hql).setParameter(1,queryString).list();

            case emailOption:
                hql += "user.email like %?%";
                return  session.createQuery(hql).setParameter(1,queryString).list();
            case mobileOption:
                hql += "user.mobile == ?";
                return  session.createQuery(hql).setParameter(1,queryString).list();
            case qqOption:
                hql += "user.sex like %?%";
                return  session.createQuery(hql).setParameter(1,queryString).list();
            case OriginOption:
                hql += "user.origin like %?%";
                return  session.createQuery(hql).setParameter(1,queryString).list();
            default: return null;
        }

    }



}
