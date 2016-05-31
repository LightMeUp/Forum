package com.SE3Forum.fzu.JTest;

import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Service.TopicService;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;
import org.junit.Test;

/**
 * Created by Feng on 5/28/16.
 */
public class TopicTest {

    @Test
    public void testAdd(){
        TopicService service = new TopicService();
        Topic topic = new Topic();
        topic.setCreateDate(Utils.getCurrentDate());
        topic.setTheme("软件工程论坛通知贴");
        topic.setContent("软件工程论坛内部测试正式开始");
        topic.setOnTop(1);
        topic.setUser(new UserCountService().findService(221300201));
        topic.setType("Notification");

        service.addService(topic);
    }


}
