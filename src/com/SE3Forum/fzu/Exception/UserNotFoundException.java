package com.SE3Forum.fzu.Exception;

import javax.servlet.ServletException;

/**
 * Created by Feng on 4/30/16.
 */
public class UserNotFoundException extends ServletException {
    public UserNotFoundException(String message){
        super(message);
        System.out.print(message);
    }
}
