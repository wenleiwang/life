package com.wenwen.blog.service.learn.time;

import com.wenwen.blog.util.DateTimeUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WangWenLei
 * @DATE: 2021/4/25
 **/
public class Main {
    public static void main(String[] args) {
//        String time = "2020-4-1";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date date = simpleDateFormat.parse(time);
//            System.out.println(DateTimeUtils.getFirstDayOfMonth(date));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        BigDecimal a= new BigDecimal(100);
        int b=100;
        boolean s= a.equals(b);
        System.out.println(s);
    }
}
