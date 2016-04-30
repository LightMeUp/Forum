package Util;

import java.util.Random;

/**
 * Created by Feng on 3/30/16.
 */
public class Utils {
      enum UserType{
        Student,Teacher,Administrator
    }

    public static  int getTouristId()
    {
        Random random = new Random();
        int  number = random.nextInt(90000);
        if (number == 0){
            return getTouristId();
        }
        int randomId = number +10000;
        return randomId;
    }


}
