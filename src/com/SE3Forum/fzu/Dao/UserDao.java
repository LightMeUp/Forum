package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Feng on 6/15/16.
 */
public class UserDao extends BaseDao {

    // 添加一个好友
    public void addFriend(Serializable id,UserCount userCount){
        User user= (User) find(User.class,id);
        Set<UserCount> userCountList = new HashSet<>();
        userCountList.add(userCount);
        user.setFriends(userCountList);
        update(user);
    }

    // 查看是否关注
    public boolean isWatched(Serializable id,UserCount userCount){
        User user= (User) find(User.class,id);
        Set<UserCount> friends =  user.getFriends();
        return  friends.contains(userCount);
    }
    public Set<UserCount> getFriends(Serializable id){
       Session session= HibernateUtil.getSession();
        User user = (User)session.get(User.class,id);
        Set<UserCount> friends =user.getFriends();
        session.close();
        return friends;
    }
    public Set<Topic> getTopics(Serializable id){
        Session session= HibernateUtil.getSession();
        User user = (User)session.get(User.class,id);
        Set<Topic> topics =user.getTopics();
        session.close();
        System.out.println(topics);
        return topics;
    }
}
