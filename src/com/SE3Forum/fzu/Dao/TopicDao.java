package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Util.HibernateUtil;
import com.SE3Forum.fzu.Util.platForumType;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Feng on 5/9/16.
 */
public class TopicDao  extends BaseDao implements ITopicDao{

    @Override
    public List<Topic> findTopicswithplatOption( platForumType type) {
        String hql="";
       switch (type)
       {
           case StudyPlat:

               hql = "From Topic as topic where topic.type = '"+ "Study'order by topic.createDate desc ";
           break;
           case FreeZonePlat:
               hql = "From Topic as topic where topic.type = '"+ "FreeZone'order by topic.createDate desc ";
               break;
           case SubjectDiscussPlat:
               hql = "From Topic as topic where topic.type = '"+ "SubjectDiscuss' order by topic.createDate desc ";
               break;
           case OthersPlat:
               hql = "From Topic as topic where topic.type = '"+ "Other' order by topic.createDate desc ";
               break;
           case Notification:
               hql = "From Topic as topic where topic.type = '"+ "Notification' order by topic.createDate desc ";
       }
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(hql);
        return query.list();
    }
}
