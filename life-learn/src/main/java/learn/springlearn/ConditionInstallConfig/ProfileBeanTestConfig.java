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
    public String initBeanTest(){
        System.out.println("加载测试类！");
        return "加载测试类";
    }

    @Bean
    @Profile("dev")
    public String initBeanPro(){
        System.out.println("加载正式类！");
        return "加载正式类";
    }
}
