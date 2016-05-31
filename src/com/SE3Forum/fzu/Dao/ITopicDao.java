package com.SE3Forum.fzu.Dao;

import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Util.platForumType;

import java.util.List;

/**
 * Created by Feng on 5/26/16.
 */
public interface ITopicDao   {
    public List<Topic> findTopicswithplatOption( platForumType type);

}
