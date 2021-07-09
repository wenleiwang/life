package learn.JSON.gsonLearn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WangWenLei
 * @DATE: 2021/6/22
 **/
public class JsonToObj {
    public static void main(String[] args) {
        String json = "{\"name1\":\"wwl1\",\"AGE\":25" +
                ",\"SEX\":\"y\",\"HEIGHT\":170.2,\"MONEY\":20210421}";
        Gson gson = new GsonBuilder().create();
        // 单个class的解析
        Student student = gson.fromJson(json, Student.class);
        System.out.println(student.toString());

        // 简单数组的解析
        String json1 = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(json1, String[].class);
        Arrays.stream(strings).forEach(item -> System.out.println(item + " "));
        System.out.println();

        //对于Java来说List<String> 和List<User> 这俩个的字节码文件
        // 只一个那就是List.class，这是Java泛型使用时要注意的问题 泛型擦除
        //Gson为我们提供了TypeToken来实现对泛型的支持，所以当我们
        // 希望使用将以上的数据解析为List<String>时需要这样写
        List<String> o = gson.fromJson(json1, new TypeToken<List<String>>() {}.getType());
        o.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 对于对象
        String jsonArray = "[{\"name\":\"wwl1\",\"age\":25,\"sex\":\"y\"," +
                "\"height\":170.2,\"money\":20210421},{\"name\":\"wwl2\"," +
                "\"age\":25,\"sex\":\"y\",\"height\":170.2,\"money\":20210421}]";
        List<Student> list = gson.fromJson(jsonArray,new TypeToken<List<Student>>(){}.getType());
        System.out.println(list.toString());
    }
}
