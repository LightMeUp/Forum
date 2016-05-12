package com.SE3Forum.fzu.Struct.FormBeans;

import com.SE3Forum.fzu.Bean.users.User;
import org.apache.struts.action.ActionForm;

/**
 * Created by Feng on 5/5/16.
 */
public class loginFormBean  extends ActionForm {
    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
