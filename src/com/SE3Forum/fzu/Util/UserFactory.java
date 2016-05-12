package com.SE3Forum.fzu.Util;

import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.Teacher;
import com.SE3Forum.fzu.Bean.users.User;

/**
 * Created by Feng on 5/12/16.
 */
public class UserFactory {
    private  UserType userType;

    public User getUser(String id){
        userType = Utils.getUsertype(id);
        switch (userType){
            case studentType:
                return new Student();
            case TeacherType:
                return new Teacher();

        }
        return null;
    }
}
