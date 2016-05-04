package com.SE3Forum.fzu.Exception;

/**
 * Created by Feng on 4/30/16.
 */
public class UserInforNotMatchException extends  Exception {
     private String message;
    public UserInforNotMatchException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
