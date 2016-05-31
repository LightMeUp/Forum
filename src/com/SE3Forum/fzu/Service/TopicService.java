package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Dao.TopicDao;
import com.SE3Forum.fzu.Util.platForumType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/9/16.
 */
public class TopicService  implements ITopicService{
    private TopicDao topicDao;
    public TopicService(){topicDao=new TopicDao();}

    @Override
    public Boolean addService(Topic topic) {
        try {
            topicDao.add(topic);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public Boolean deleteService(Serializable id) {
       Topic topic= (Topic) topicDao.find(Topic.class, id);
        if (topic==null) {
            return false;
        }else {
            try {
                topicDao.delete(topic);
                return true;
            }catch (Exception e){
                return false;
            }

        }
    }

    @Override
    public Boolean updateServcie(Topic topic) {
      try {
          Topic t= (Topic) topicDao.find(Topic.class,topic.getId());
          t.setContent(topic.getContent());
          t.setImages(topic.getImages());
          t.setUser(topic.getUser());
          t.setPosts(topic.getPosts());
          t.setTheme(topic.getTheme());
          topicDao.update(t);
          return true;
      }catch (Exception e){
          return  false;
      }
    }

    @Override
    public Post findService(Class clazz, Serializable id) {
       return (Post) topicDao.find(Topic.class, id);

    }

    @Override
    public List<Topic> listAllService(String tableName) {
        return topicDao.listAll(tableName);
    }

    @Override
    public int getRowsService(String tableName) {
        return 0;
    }

    @Override
    public Topic findTopoicByName(String name) {
        return null;
    }

    @Override
    public List<Topic> findTopicWithplatOption(platForumType type) {
        return topicDao.findTopicswithplatOption(type);
    }

    @Override
    public List<Topic> findTopicWithOption(String Option, SearchOption searchOption) {
        return null;
    }
}
