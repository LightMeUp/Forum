package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.Post_Comments.Post;
import com.SE3Forum.fzu.Bean.Post_Comments.Topic;
import com.SE3Forum.fzu.Util.platForumType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/11/16.
 */
public interface ITopicService {
    //添加
    Boolean addService(Topic topic);

    //删除
    Boolean deleteService(Serializable id);

    // 修改
    Boolean updateServcie(Topic topic);

    // 查询单个数据
    Topic findService( Serializable id);

    // 查看全部数据
    List<Topic> listAllService(String tableName);

    // 获取行数
    int  getRowsService(String tableName);


    // search by filename
    Topic findTopoicByName(String name);
    //内部先实例化一个SearchOption的对象

    List<Topic> findTopicWithplatOption(platForumType type);
    // 上面的查找方法里面只要调用这个方法就可以,传入一个SearchOption的枚举类型
    List<Topic>findTopicWithOption(String Option, SearchOption searchOption);
    /*
        局部变量建议一定要实例话
        List<Teacher> teaches = new Arraylist<>();
        switch(searchOption){
            case: serarchOption{

                // 调用Dao层方法
                teachers = teacherDao


            }
        }
    * */
}
