package com.bjpwoernode.settings.test;

import com.bjpwoernode.crm.utils.DateTimeUtil;
import com.bjpwoernode.crm.utils.MD5Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
       /* //验证失效时间
        String expireTime = "2020-10-10 10:10:10";
        //当前系统时间
        String currentTime = DateTimeUtil.getSysTime();
        int count =expireTime.compareTo(currentTime);
        System.out.println(count);

        String lockState = "0";
        if ("0".equals(lockState)){
            System.out.println("账号已锁定");
        }*/

        //

        String pwd = "456";
        String str = MD5Util.getMD5(pwd);
        System.out.println(str);
    }
}
