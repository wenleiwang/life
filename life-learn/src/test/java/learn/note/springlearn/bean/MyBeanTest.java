package learn.note.springlearn.bean;

import learn.note.springlearn.bean.ConfigurationPropertiesTest.MyBean;
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
        String name = myBean.getName();
        System.out.println(name);
        Assert.hasText("wenlei",name);
    }
}
