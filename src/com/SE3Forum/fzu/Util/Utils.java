package com.SE3Forum.fzu.Util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * Created by Feng on 3/30/16.
 */

public class Utils {
    public  static  UUID getRandomUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid;
    }
    public static String getSecurityToken(){
       return  RandomStringUtils.randomAlphabetic(32);
    }
    public static String getFileUploadFolder(){
        if (SystemUtils.IS_OS_MAC)
            return "/Users/Feng/Documents/SE3Form/Files/upload";
        return "C:/Users/Jerry/Documents/SE3/files";
    }

    public static String getImageUploadFolder() {
        if (SystemUtils.IS_OS_MAC)
            return "/Users/Feng/Documents/SE3Forum/images/upload";
        return "C:/Users/Jerry/Documents/SE3/files";
    }
    public static String getCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date =new java.util.Date();
        String  currentDate = dateFormat.format(date);
        System.out.println(new java.util.Date());
        return  currentDate;
    }
    public static UserType getUsertype(String id){

        String str = id.substring(0,4);
        System.out.println(str);
        if ("2213".equals(str)){
            System.out.println("学生登录");
            return UserType.studentType;
        }
        else if("2201".equals(str)) {
            System.out.println("教师登录");
            return UserType.TeacherType;
        }
        else {
            System.out.println("未知用户");
            return UserType.UnknownType;
        }
    }

}
