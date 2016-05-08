package com.SE3Forum.fzu.Bean.Post_Comments;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Feng on 5/8/16.
 */
/* 用户发帖,发主题时包含图片,学习资料中包含图片*/
@Entity
@Table(name="image",schema = "ForumDatabase")
public class image {
    private int uuid;   //图片名称号,使用Util下uuid生成方法生成
    private String name;  //文件上传时名称

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }
}
