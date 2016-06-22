package com.SE3Forum.fzu.JTest;

import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Dao.UserDao;
import com.SE3Forum.fzu.Service.TopicService;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Service.postService;
import com.SE3Forum.fzu.Util.Utils;
import com.SE3Forum.fzu.Util.platForumType;
import org.apache.struts2.components.Date;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Feng on 5/28/16.
 */
public class TopicTest {

    @Test
    public void testAdd(){
        TopicService service = new TopicService();
        Topic topic = new Topic();
        topic.setCreateDate(Utils.getCurrentDate());
        topic.setTheme(" 软件工程论坛开发第10周");
        topic.setContent("第十周开发日志");
        topic.setOnTop(1);
        topic.setUser(new UserCountService().findService(221300209));
        topic.setType("Study");

        service.addService(topic);
    }
    @Test
    public void testAddPostToTopic(){
        UserCount userCount = new UserCountService().findService(221300201);
        TopicService service = new TopicService();
        Topic topic = service.findService(1);
        Post post = new Post();
        post.setContent("厉害");
        post.setCreateDate(Utils.getCurrentDate());
        post.setUser(userCount);
        post.setTopic(topic);
        Set<Post> posts = new HashSet<>();
        posts.add(post);
        topic.setPosts(posts);
        new postService().addService(post);
        service.updateServcie(topic);
        System.out.println(topic.getPosts());
    }
    @Test
    public void testfind(){
        TopicService service = new TopicService();
        Topic topic = service.findService(1);
        System.out.println(topic.getPosts().size());
        for (Post post:topic.getPosts()) {
            System.out.println(post.getId());
            System.out.println(post.getContent());
            System.out.println(post.getUser().getId());
        }
    }
    @Test
    public void test()
    {
        User user  =(User) new UserDao().find(User.class,221300201);
        System.out.println(user.getTopics());

    }


}
