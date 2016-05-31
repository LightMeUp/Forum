package com.SE3Forum.fzu.Service;

import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Dao.UserCountDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/23/16.
 */
public class UserCountService  implements IUserCountService {
    private UserCountDao dao;
    public UserCountService(){
        dao = new UserCountDao();
    }

    @Override
    public Boolean addService(UserCount user) {

        UserCount userCount = (UserCount) dao.find(UserCount.class, user.getId());
        if (userCount != null){
            return false;
        }
        else {
            dao.add(user);
            return true;
        }
    }

    @Override
    public Boolean deleteService(Serializable id) {

       UserCount userCount =(UserCount) dao.find(UserCount.class,id);
        if (userCount == null)
        {
            return false;
        }
        else {
            dao.delete(id);
            return true;

        }
    }

    @Override
    public Boolean updateServcie(UserCount user) {

        UserCount userCount =(UserCount) dao.find(UserCount.class,user.getId());
        if (user ==null){
            return false;
        }
        else {
            // 修改用户名
            userCount.setName(user.getName());

            //修改性别
            userCount.setSex(user.getSex());
            // 修改头像
            userCount.setHeadimage(user.getHeadimage());
            //修改密码
            userCount.setPassword(user.getPassword());
            //修改出生日期
            userCount.setBirthDate(user.getBirthDate());
            //修改qq
            userCount.setQqnumber(user.getQqnumber());
            //修改电话
            userCount.setCellPhone(user.getCellPhone());
            //修改邮箱
            userCount.setEmail(user.getEmail());
            // 修改籍贯
            userCount.setOrigin(user.getOrigin());
            //修改地址
            userCount.setAddress(user.getAddress());

            //修改最后一次登录信息
            userCount.setLastLoginDate(user.getLastLoginDate());
            dao.update(userCount);
            return true;

        }

    }

    @Override
    public UserCount findService(Serializable id) {
        return (UserCount) dao.find(UserCount.class,id);
    }

    @Override
    public List<UserCount> findByOption(String queryString, SearchOption option) {
        return dao.findByOption(queryString,option);
    }


    @Override
    public List<UserCount> listAllService() {
        return dao.listAll("UserCount");
    }

    @Override
    public int getRowsService() {
        return dao.getRows("UserCount").intValue();
    }
}
