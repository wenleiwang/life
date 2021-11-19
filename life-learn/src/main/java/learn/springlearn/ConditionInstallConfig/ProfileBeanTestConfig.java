package learn.springlearn.ConditionInstallConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author WangWenLei
 * @DATE: 2021/11/19
 **/
@Configuration
public class ProfileBeanTestConfig {
    @Bean
    @Profile("test")
    public BeanTest initBeanTest(){
        System.out.println("加载测试类！");
        return new BeanTest();
    }

    @Bean
    @Profile("dev")
    public BeanPro initBeanPro(){
        System.out.println("加载正式类！");
        return new BeanPro();
    }
}
