package ink.poesy.life;

import org.apache.tomcat.util.buf.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @author WangWenLei
 * @DATE: 2020/9/14
 **/
//@SpringBootTest
public class StreamTest {
    @Test
    public void test(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> fil = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表："+ fil);

        String mer = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(";"));

        System.out.println("合并字符串："+ mer);
    }


    @Test
    public void test1(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> collect = strings.stream().filter(item->item.equals("abc")).collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    public void test2(){
        //获取所有的属性
        Properties properties = System.getProperties();
        //遍历所有的属性
        for (String key : properties.stringPropertyNames()) {
            //输出对应的键和值
            System.out.println(key + "=" + properties.getProperty(key));
        }

    }

    @Test
    public void test3(){
        System.out.println();

    }
}
