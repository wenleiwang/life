package ink.poesy.life;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
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
}
