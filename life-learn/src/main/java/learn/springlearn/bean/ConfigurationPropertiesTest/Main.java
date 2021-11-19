package learn.springlearn.bean.ConfigurationPropertiesTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangWenLei
 * @DATE: 2021/11/19
 **/
@Configuration
public class Main {
    @Autowired
    MyBean myBean;

    @Bean
    public void testConfigurationProperties (){
        System.out.println(myBean.getMsg());
    }
}
