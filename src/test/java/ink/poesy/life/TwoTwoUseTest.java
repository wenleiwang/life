package ink.poesy.life;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author WangWenLei
 * @DATE: 2020/9/25
 **/
//@SpringBootTest
public class TwoTwoUseTest {
    public static void printValur(String str) {
        System.out.println("print value : " + str);
    }

    @Test
    public void main1() {
        List<String> al = Arrays.asList("a", "b", "c", "d");
        al.forEach(TwoTwoUseTest::printValur);
        // 下面的方法和上面等价的
        Consumer<String> methodParam = TwoTwoUseTest::printValur; // 方法参数
        al.forEach(x -> methodParam.accept(x));// 方法执行accept
    }

    public void test(){

    }


}
