package com.SE3Forum.fzu.Util;

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
            return "/Users/Feng/SE3Form/Files/upload";
        return "/var/SE3/Form/Files/upload/";
    }

    public static String getImageUploadFolder() {
        if (SystemUtils.IS_OS_MAC)
            return "/Users/Feng/SE3Forum/images/upload";
        return "/var/SE3/Form/images/upload/";
    }

}
