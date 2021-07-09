package learn.spring.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * @author WangWenLei
 * @DATE: 2021/6/15
 **/
@SpringBootTest
public class MyBeanTest {
    @Autowired
    MyBean myBean;

    @Test
    public void test(){
        String name = myBean.name;
        System.out.println(name);
        Assert.hasText("wenlei",name);
    }
}
