package com.SE3Forum.fzu.Struct.FormBeans;

import org.apache.struts.action.ActionForm;

/**
 * Created by Feng on 5/5/16.
 */
public class loginFormBean  extends ActionForm {
    private String id;
    private String password;
    private String userType;
    private String LoginType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        if ("2201".indexOf(id) >1){
            userType = "teacher";
        }else{
            userType = "student";
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLoginType() {
        return LoginType;
    }

    public void setLoginType(String loginType) {
        LoginType = loginType;
    }
}
