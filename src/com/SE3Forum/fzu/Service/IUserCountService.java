package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.UserCount;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/23/16.
 */
public interface IUserCountService {
    Boolean addService(UserCount user);

    //删除
    Boolean deleteService(Serializable id);

    // 修改
    Boolean updateServcie(UserCount user);

    // 查询 查询条件查询单个数据
    UserCount findService(Serializable id);
    List<UserCount> findByOption(String queryString, SearchOption option);

    // 查看全部数据
    List<UserCount> listAllService();


    // 查询表为UserCount
    int  getRowsService();

}
