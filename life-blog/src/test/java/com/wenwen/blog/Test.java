package com.wenwen.blog;


import com.wenwen.blog.entity.User;
import com.wenwen.blog.entity.UserBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author WangWenLei
 * @DATE: 2021/2/2
 **/
public class Test {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setUserName("wenwen1");
        user1.setUserPassword("123456");
        user1.setLoginName("wenwen1");
        user1.setRealName("测试1");
        User user2 = new User();
        user2.setUserName("wenwen2");
        user2.setUserPassword("123456");
        user2.setLoginName("wenwen2");
        user2.setRealName("测试2");
        User user3 = new User();
        user3.setUserName("wenwen1");
        user3.setUserPassword("12345677");
        user3.setLoginName("wenwen1");
        user3.setRealName("测试3");
        User user4 = new User();
        user4.setUserName("wenwen1");
        user4.setUserPassword("123456");
        user4.setLoginName("wenwen1");
        user4.setRealName("测试1");
        User user5 = new User();
        user5.setUserName("wenwen1");
        user5.setUserPassword("12345677");
        user5.setLoginName("wenwen1");
        user5.setRealName("测试3");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        List<UserBase> userBaseList = new ArrayList<>();
//        Map<String, List<User>> collect = list.stream().collect(Collectors.groupingBy(User::getUserName));
//        collect.keySet().forEach(item ->{
//            Map<String, Long> collect1 = collect.get(item).stream().collect(Collectors.groupingBy(o -> o.getRealName(), Collectors.counting()));
//            collect1(key);
//        });

        Map<String, Long> countMap = list.stream().collect(Collectors.groupingBy(o -> o.getUserName() + "_" + o.getRealName(),Collectors.counting()));
        List<UserBase> countRecords = countMap.keySet().stream().map(key -> {
            String[] temp = key.split("_");
            String productType = temp[0];
            String country = temp[1];

            UserBase record = new UserBase();
            record.setLoginName(productType);
            record.setUserPassword(country);
//            record.set(countMap.get(key).intValue());
            System.out.println(countMap.get(key).intValue());
            return record;
        }).collect(Collectors.toList());
        System.out.println(countRecords);
    }

}
