package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/9/16.
 */
public class TopicService  implements ITopicService{


    @Override
    public Boolean addService(Topic topic) {
        return null;
    }

    @Override
    public Boolean deleteService(Serializable id) {
        return null;
    }

    @Override
    public Boolean updateServcie(Topic topic) {
        return null;
    }

    @Override
    public Post findService(Class clazz, Serializable id) {
        return null;
    }

    @Override
    public List<Topic> listAllService(String tableName) {
        return null;
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
    public List<Topic> findTopicWithOption(String Option, SearchOption searchOption) {
        return null;
    }
}
