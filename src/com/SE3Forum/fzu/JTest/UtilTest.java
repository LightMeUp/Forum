package com.SE3Forum.fzu.JTest;

import com.SE3Forum.fzu.Util.Utils;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by Feng on 5/4/16.
 */
public class UtilTest  {
    @Test
    public void TestGetUUID(){
       UUID uuid = Utils.getRandomUUID();
        System.out.println(uuid);
    }
    @Test
    public void  TestGetRandomString(){
        for (int i = 0;i <151;i++) {
            String string = Utils.getSecurityToken();
            System.out.println(string);
        }
    }
}
