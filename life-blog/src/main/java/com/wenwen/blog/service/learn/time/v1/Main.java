package com.wenwen.blog.service.learn.time.v1;
import com.wenwen.blog.util.DateTimeUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author WangWenLei
 * @DATE: 2021/4/26
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(DateTimeUtils.getFirstDayOfWeek(new Date()));
    }
}
