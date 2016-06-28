package com.SE3Forum.fzu.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Bean.users.Student;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Bean.users.UserCount;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.SystemUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
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
            return "/Users/Feng/Documents/SE3Form/Images/upload";
        return "C:/Users/Jerry/Documents/SE3/uploadedImages";
    }
    public static Date getCurrentDate(){
       return new Date();
    }

    public static String parseDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  dateFormat.format(date);

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
            System.out.println("未注册用户");
            return UserType.UnknownType;
        }
    }

    public static boolean isLogin(Cookie[] cookies) {
        if (cookies == null || cookies.length < 1) {
            System.out.println("Cookie not exits");
            return false;
        }
            for (Cookie cookie:cookies){
                System.out.println(cookie.getValue());
                if (cookie.getName().equals("loginState")){
                    if (cookie.getValue().equals("YES"))
                        return true;
                }
            }
        return false;
    }
    public static boolean isLoginBySession(HttpSession session){
        UserCount user =(UserCount) session.getAttribute("user");
        System.out.println("islogin"+user==null?false:true);
        return user==null?false:true;
    }
    public static String isWatched(User watchuser, User user){
        return user.getFriends()!=null&&user.getFriends().contains(watchuser)?"true":"false";
    }

    public static String getFileString(String str){
        if (!str.contains("<a"))return null;

        return str.substring(str.indexOf("<a"),str.indexOf("</a>")+4);
    }
    public static Date parseStringToDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(date);
    }
    public static  boolean isAssignmentSubmitted(int id,Student student){
        Set<Evaluation> evaluations =student.getEvaluations();
        if (evaluations==null || evaluations.size()<1)return false;
        else {
            for (Evaluation evaluation:evaluations){
               if( evaluation.getSchoolAssignment().getId()== id)
                return true;
            }
            return false;
        }

    }
}

