package com.SE3Forum.fzu.Struct.FormBeans;

import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import org.apache.struts.action.ActionForm;

/**
 * Created by Feng on 5/17/16.
 */


/* 封装 topic form*/
public class TopicForm extends ActionForm {

    // 包含一个 topic 对象
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
