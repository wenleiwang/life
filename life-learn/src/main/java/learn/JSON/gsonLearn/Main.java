package learn.JSON.gsonLearn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WangWenLei
 * @DATE: 2021/6/21
 **/
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("wwl1",25,'y',170.2F,BigDecimal.valueOf(20210421));
        Student student2 = new Student("wwl2",25,'y',170.2F,BigDecimal.valueOf(20210421));
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        // 构建
        GsonBuilder gsonBuilder = new GsonBuilder();
        // 创建Gson对象
        Gson gson = gsonBuilder.create();
        // 序列化
        String s = gson.toJson(student1);
        System.out.println(s);
    }
}
