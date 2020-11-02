package com.cn.httpsms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by ldn on 2017/11/17.
 */
public class testMain {
    public static void main(String[] args){
        //-----------------------------------------
//        Random rand = new Random();
//
//
//        System.out.println(new Date().toString());
//            System.out.println(new Date(System.currentTimeMillis()+(rand.nextInt(30) + 1)*1000).toString());
//
//        Date d1=new Date();
//        Date d2=new Date(System.currentTimeMillis()-(rand.nextInt(10) + 1)*1000);
//        long _chaValue=((d1.getTime() - d2.getTime()));
//        System.out.println(_chaValue);
        //--------------------------------------------

        //获取日期时间 星期几
        //方法一
//        String time =(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
//        String time =(new SimpleDateFormat("MM月dd日 HH:mm")).format(new Date());
//        System.out.println(time);
//        String xingqi=new SimpleDateFormat("EEEE").format(new Date());
//        System.out.println(xingqi);

        //方法二
//        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        int week_int = cal.get(Calendar.DAY_OF_WEEK) - 1;
//        if (week_int < 0)
//            week_int = 0;
//        System.out.println(weekDays[week_int]);
        //--------------------------------------------
        String date =(new SimpleDateFormat("MM月dd日")).format(new Date());
        String time =(new SimpleDateFormat("HH:mm")).format(new Date());
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int week_int = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_int < 0)
            week_int = 0;
        String b_t0_string=date+" "+weekDays[week_int];
        String b_t1_string=time;
        System.out.println(b_t0_string);
        System.out.println(b_t1_string);
    }
}
