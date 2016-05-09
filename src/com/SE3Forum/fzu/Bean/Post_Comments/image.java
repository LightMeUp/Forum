package com.SE3Forum.fzu.Bean.Post_Comments;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Feng on 5/8/16.
 */
/* 用户发帖,发主题时包含图片,学习资料中包含图片
*  图片上传属于文件传输的一种,这里的图片指的是用户在发帖或者发布主题中添加的图片
*  此时的图片信息会被加载到topic 对象或者post 对象中,所以不再记录上传用户信息
*  此外用户个人信息中的图片与此处属于相同的原因
*  图片中会用到一种图片裁剪处理,这个在这里暂时不处理,后面页面做好后我会使用阿里云的图片裁剪来做*/
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
